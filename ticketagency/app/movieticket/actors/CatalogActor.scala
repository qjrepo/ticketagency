package movieticket.actors

import movieticket.actors.message.CatalogMessage.{ListAllItems, listAllAvailable, listAllBuyinfo, listbuyinfoforidmovie, update}

import scala.concurrent.{Await, ExecutionContext, Future}
import ExecutionContext.Implicits.global
import javax.inject.{Inject, Named}
import models.Ticket

import scala.concurrent.duration._
import akka.util.Timeout
import play.api.Configuration
import play.modules.reactivemongo.ReactiveMongoApi
import reactivemongo.play.json.collection.JSONCollection
import play.api.libs.json.JsObject
import reactivemongo.api.{Cursor, ReadPreference}
import reactivemongo.bson.BSONDocument
import reactivemongo.play.json._
import javax.inject.Inject
import akka.actor.{Actor, ActorRef, ActorSystem}
import akka.actor.Props
import movieticket.controllers.HomeController
import movieticket.models.Buyinfo


  object CatalogActor{
    def props: Props = Props(classOf[CatalogActor])
  }


class CatalogActor

  extends Actor {

  implicit val ec = ExecutionContext.global


    def receive: Receive = {

       //message listallitems
      case ListAllItems(reactiveMongoApi) =>

        def collection4:Future[JSONCollection] =
          reactiveMongoApi.database.map(_.collection("ticket"))
        def list4(limit:Int = 100000): Future[List[Ticket]] ={
          collection4.flatMap(
            _.find(BSONDocument(),Option.empty[JsObject])
              .cursor[Ticket](ReadPreference.primary)
              .collect[List](limit,Cursor.FailOnError[List[Ticket]]())
          )
        }
        val list = list4(100000)

        sender() ! Await.result(list, 5000.seconds)
      //message listallavail
      case listAllAvailable(reactiveMongoApi) =>
        def collection4:Future[JSONCollection] =
          reactiveMongoApi.database.map(_.collection("ticket"))
        def list4(limit:Int = 10000): Future[List[Ticket]] ={
          collection4.flatMap(
            _.find(BSONDocument(),Option.empty[JsObject])
              .cursor[Ticket](ReadPreference.primary)
              .collect[List](limit,Cursor.FailOnError[List[Ticket]]())
          )
        }
        val list = list4(13000)
        val tickets = Await.result(list, 1.5.seconds).filter(_.filled == 0)
        sender() ! tickets
      // message to listall buyinfo
      case listAllBuyinfo(reactiveMongoApi) =>

        def collection5:Future[JSONCollection] =
          reactiveMongoApi.database.map(_.collection("buyinfo"))
        def list5(limit:Int = 10000): Future[List[Buyinfo]] ={
          collection5.flatMap(
            _.find(BSONDocument(),Option.empty[JsObject])
              .cursor[Buyinfo](ReadPreference.primary)
              .collect[List](limit,Cursor.FailOnError[List[Buyinfo]]())
          )
        }
        val list = list5(10000)

        sender() ! Await.result(list, 1.seconds)
      // message to list buyinfo for every movie
      case listbuyinfoforidmovie(reactiveMongoApi, id) =>
        def collection8: Future[JSONCollection] =
          reactiveMongoApi.database.map(_.collection("ticket"))

        def list6(limit: Int = 100000): Future[List[Ticket]] = {
          collection8.flatMap(
            _.find(BSONDocument(), Option.empty[JsObject])
              .cursor[Ticket](ReadPreference.primary)
              .collect[List](limit, Cursor.FailOnError[List[Ticket]]())
          )
        }

        val list2 = list6(100000)
        val movietilist = Await.result(list2, 5000.seconds).filter(_.movie_id == id)
        println(movietilist)
        sender() ! movietilist

    }
}
