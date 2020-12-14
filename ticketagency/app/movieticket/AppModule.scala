package movieticket


import movieticket.actors.CatalogActor
import akka.actor.{ActorRef, ActorSystem, Props}
import javax.inject.{Inject, Named}
import movieticket.controllers.HomeController
import play.api.inject._
import play.api.{Configuration, Environment}
import play.modules.reactivemongo.ReactiveMongoApi
import service.CatalogService
import play.api.Configuration
import play.api.PlayException

import scala.concurrent.ExecutionContext
import actors.CatalogActor

trait ModuleContext {
  val reactiveMongoApi: ReactiveMongoApi
}

trait module extends Module

//@Inject()
 class AppModule extends module {

   import movieticket.controllers.HomeController


   override def bindings(environment: Environment,
                        configuration: Configuration): Seq[Binding[_]] = {

    val actorSystem: ActorSystem = ActorSystem("ticket")
    // initiate the catalogactor
    val catalogActor = actorSystem.actorOf(Props[CatalogActor])

    Seq(
      bind[ActorRef].qualifiedWith("catalogActor").toInstance(catalogActor),
      bind[CatalogService].toSelf
    )
  }

}