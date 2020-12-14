package movieticket.controllers

import movieticket.actors.CatalogActor
import akka.actor.{ActorSystem, Props}
import javax.inject._
import models.{Movie, Ticket, User}
import play.api.libs.json._

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext
import play.modules.reactivemongo.ReactiveMongoApi
import reactivemongo.play.json.collection.JSONCollection
import movieticket.service.CatalogService

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.Future
import play.api.libs.json.JsObject
import reactivemongo.api.{Cursor, ReadPreference}
import reactivemongo.bson.BSONDocument
import reactivemongo.play.json._
import javax.inject.Inject
import movieticket.models.Buyinfo
import play.api.Configuration
import play.api.mvc.{AbstractController, ActionBuilder, AnyContent, ControllerComponents, Request, Result}
import play.modules.reactivemongo._
import reactivemongo.api.bson.BSONObjectID
import reactivemongo.api.commands.WriteResult

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */


@Singleton
class HomeController @Inject()(cc: ControllerComponents,
                               val reactiveMongoApi: ReactiveMongoApi,
                               catalogService: CatalogService,
                               config: Configuration
                              )(implicit exec:ExecutionContext)
  extends AbstractController(cc) {

  var customername ="unknown"

  def index = Action{
    Ok("Your new application is ready.")
  }

  def usercollect:Future[JSONCollection]= reactiveMongoApi.database.map(_.collection("users"))
  def moviecollect:Future[JSONCollection]= reactiveMongoApi.database.map(_.collection("movie"))
  def collection3:Future[JSONCollection]= reactiveMongoApi.database.map(_.collection("ticket"))
  def buyinfocollect:Future[JSONCollection]= reactiveMongoApi.database.map(_.collection("buyinfo"))


  /** list all kind of movie, ticket information
   * @param limit
   * @return
   */

    //read movie data from mongodb collection
  def list2(limit:Int = 100): Future[List[Movie]] ={
    moviecollect.flatMap(
      _.find(BSONDocument(),Option.empty[JsObject])
        .cursor[Movie](ReadPreference.primary)
        .collect[List](limit,Cursor.FailOnError[List[Movie]]())
    )
  }

  //list all movie basic information
  def listMovies = Action.async{
    list2(100).map{movies=>Ok(Json.toJson(movies) )}
  }


  //list all movie & seat information
  def listTicket = Action.async{_ =>
    catalogService.listCatalog.map{tickets=>Ok(Json.toJson(tickets))}
  }

  //list all available ticket
  def listAvailTicket = Action.async{_ =>
    catalogService.listAvail.map{tickets=>Ok(Json.toJson(tickets))}
  }
  //list all buy information
  def listBuyinfo = Action.async{_ =>
    catalogService.listBuyinfo.map{buyinfos=>Ok(Json.toJson(buyinfos))}
  }
  //list all available ticket for special movie by actors
  def listticketbymvid(id:Int) = Action.async{_ =>
    catalogService.listticketbymovieid(id).map{tickets=>Ok(Json.toJson(tickets))}
  }

  //read ticket data from mongodb collection
  def list4(limit:Int = 1000000): Future[List[Ticket]] ={
    collection3.flatMap(
      _.find(BSONDocument(),Option.empty[JsObject])
        .cursor[Ticket](ReadPreference.primary)
        .collect[List](limit,Cursor.FailOnError[List[Ticket]]())
    )
  }
  //list all ticket information from 1 million record
  def listall = Action.async{
         list4(1000000).map{tickets=>Ok(Json.toJson(tickets) )}
  }
  //list all available ticket for special movie from 1 million record
  def listspec(id:Int)=Action.async{
    list4(1000000).map{ i => i.filter(_.movie_id == id).filter(_.filled == 0)}
      .map{tickets=>Ok(Json.toJson(tickets) )}
  }


  /**
   * The JSONCollection.update() method returns Future [Update WriteResult],
   * Update WriteResult. n denotes the number of records matching conditions,
   * and Update WriteResult. nModified denotes the number of records actually modified
   * (excluding records with the same update value and original value,
   * since these records are not actually modified), Update WriteResult.
   * upse. Rted returns a list of records_id upserted.
   * @param id
   * @return
   */

  //user try to buy ticket and get the message
  def ticketIsNotFill(id: Int,username:String) = Action.async{

    findTicketById(id).map{
      i => i.filled match {
        case 0 => {findUserByname(username) match{
          case true => Ok("please log in")
          case false => buy(id,username)
            Ok("buy")
        }
        }
        case 1 => Ok("cannot buy")
      }
    }
  }

  // find the specific ticket by ticketid
  def findTicketById(id:Int)={
    val list = collection3.flatMap(
      _.find(BSONDocument("id"->id),Option.empty[JsObject])
        .cursor[Ticket](ReadPreference.primary)
        .collect[List](1,Cursor.FailOnError[List[Ticket]]())
    )
    list.map{a=>a.head}
  }

  //update ticket information if this ticket is avaliable
  def buy(id: Int,username:String) ={

    collection3.flatMap {
      _.update(ordered = false)
        .one(Json.obj("id" -> id), Json.obj("$set" -> Json.obj("filled" -> 1)))
    }
    newTicket(id,username)
  }

  // create new buyinfo and insert into mongodb
  def newTicket(id: Int,username:String)={

    val buyinfo = Await.result(findTicketById(id).map{i=> new Buyinfo(username,i.id,i.seatno)},1000.seconds)
    buyinfocollect.flatMap(_.insert.one(buyinfo))
  }




  /**
   * create new user and list all user basic information
   * @return
   */
  def list(limit:Int = 100000): Future[Seq[User]] ={
    usercollect.flatMap(
      _.find(BSONDocument(),Option.empty[JsObject])
        .cursor[User](ReadPreference.primary)
        .collect[Seq](limit,Cursor.FailOnError[Seq[User]]())
    )
  }
  def listUsers = Action.async{
    list(100).map{users=>Ok(Json.toJson(users) )}
  }

  // insert new user information in mongodb
  def create(user:User):Future[WriteResult]={
    usercollect.flatMap(
      _.insert.one(user))}

  // user register
  def createUser = Action.async(parse.json){
    _.body
      .validate[User].map{
      user => findUserByname(user.username) match {
        case true =>  create(user).map{_=>Ok("User created")}
        case false => Future{Ok("User already existed")}
      }
    }
      .getOrElse(Future.successful((BadRequest("Invalid format"))))
  }


  // find the specific user by username
  def findUserByname(username:String)={
    val userlist = usercollect.flatMap(
      _.find(BSONDocument("username"->username),Option.empty[JsObject])
        .cursor[User](ReadPreference.primary)
        .collect[List](1,Cursor.FailOnError[List[User]]())
    )
    Await.result(userlist,100.seconds).size==0

  }

  /**
   * In order to buy ticket, the user should log in our website
   * @param   username,password
   * @return  the message which told user if he or she can log in
   */

  // find the specific user by username
  def findUser(username:String,password:String)={
    val userlist = usercollect.flatMap(
      _.find(BSONDocument("username"->username,"password"->password),Option.empty[JsObject])
        .cursor[User](ReadPreference.primary)
        .collect[List](1,Cursor.FailOnError[List[User]]())
    )
    Await.result(userlist,100.seconds).size==0
  }

  // user login function
  def login(username:String,password:String) = Action.async{
    Future{findUser(username,password)}.map{ i => i match {
      case true =>  Ok("Please Sign up first")
      case false => customername=username
        Ok("Buy ticket now!")
    }}
  }

}