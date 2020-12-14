package spec.service
import org.scalatest.{FlatSpec, Matchers}

import scala.io.{Codec, Source}
import scala.util._
import scala.concurrent.duration._
import akka.pattern.ask
import akka.testkit.TestActorRef
import akka.util.Timeout
import javax.inject.Inject
import models.Ticket
import movieticket.actors.CatalogActor
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{MustMatchers, WordSpecLike}
import movieticket.actors.message.CatalogMessage
import movieticket.actors.message.CatalogMessage.{ListAllItems, listAllAvailable, listAllBuyinfo}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import play.api.inject.Injector
import play.api.inject.guice.GuiceApplicationBuilder
import play.modules.reactivemongo.ReactiveMongoApi
import org.scalatest._

import scala.concurrent.{Await, ExecutionContext, Future}
@RunWith(classOf[JUnitRunner])
class CatalogActorSpec extends TestActorKit
  with WordSpecLike
  with MustMatchers
  with ScalaFutures
  with MockitoSugar
  with TestValues{

  implicit val ec = ExecutionContext.global
  private lazy val appBuilder: GuiceApplicationBuilder = new GuiceApplicationBuilder()
  private lazy val injector: Injector = appBuilder.injector()
  private val reactiveMongoApi: ReactiveMongoApi = injector.instanceOf[ReactiveMongoApi]

  implicit val askTimeout = Timeout(10.seconds)

  val catalogActorRef = TestActorRef(new CatalogActor())
  "A CatalogActor" must {
    "get item from catalog" in {
      val result:Future[List[Ticket]]= (catalogActorRef ? ListAllItems(reactiveMongoApi)).mapTo[List[Ticket]]
      val resultf: List[Ticket] = Await.result(result, 10.seconds)
      resultf.size mustEqual 100000
      //result mustEqual infolist
    }

}}