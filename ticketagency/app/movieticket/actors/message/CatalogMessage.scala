package movieticket.actors.message

import play.modules.reactivemongo.ReactiveMongoApi

import scala.concurrent.ExecutionContext


object CatalogMessage {
  // these are all messages for the catalog actor to receive
  case class ListAllItems(reactiveMongoApi: ReactiveMongoApi)(implicit ec: ExecutionContext) //extends CatalogInboundMessage
  case class update(id: Int)
  case class listAllAvailable(reactiveMongoApi: ReactiveMongoApi)(implicit ec: ExecutionContext)
  case class listAllBuyinfo(reactiveMongoApi: ReactiveMongoApi)(implicit ec: ExecutionContext)
  case class listbuyinfoforidmovie(reactiveMongoApi: ReactiveMongoApi, id:Int)(implicit ec: ExecutionContext)
}
