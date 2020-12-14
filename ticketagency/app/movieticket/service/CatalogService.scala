package movieticket.service

import movieticket.actors.message.CatalogMessage.{ListAllItems, listAllAvailable, listAllBuyinfo, listbuyinfoforidmovie}
import javax.inject.{Inject, Named}
import akka.actor.{ActorRef, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import models.Ticket
import movieticket.actors.CatalogActor
import movieticket.models.Buyinfo
import play.api.Configuration

import scala.language.postfixOps
import scala.concurrent.duration._
import scala.concurrent.{ExecutionContext, Future}
import play.modules.reactivemongo.ReactiveMongoApi
class CatalogService @Inject()(@Named("catalogActor") catalogActor: ActorRef,
                               val reactiveMongoApi: ReactiveMongoApi,
                               config: Configuration)
                              (implicit ec: ExecutionContext) {
  implicit val askTimeout: Timeout = Timeout(config.get[Int]("akka.ask-timeout") seconds)
  // ask the actor message of listallitem
  def listCatalog: Future[List[Ticket]]=
    (catalogActor ? ListAllItems(reactiveMongoApi)(ec)).mapTo[List[Ticket]]//mapTo[Future[List[Ticket]]]
  // ask the actor message of listavailticket
  def listAvail: Future[List[Ticket]]=
   (catalogActor ? listAllAvailable(reactiveMongoApi)(ec)).mapTo[List[Ticket]]
   // ask the actor message of listbuyinfo
  def listBuyinfo: Future[List[Buyinfo]]=
    (catalogActor ? listAllBuyinfo(reactiveMongoApi)(ec)).mapTo[List[Buyinfo]]
  //ask the actor message listticketbymv
  def listticketbymovieid(id:Int): Future[List[Ticket]] =
    (catalogActor ? listbuyinfoforidmovie(reactiveMongoApi, id)(ec)).mapTo[List[Ticket]]
}
