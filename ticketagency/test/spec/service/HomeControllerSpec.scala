package spec.service
import akka.stream.Materializer
import com.typesafe.config.ConfigFactory
import movieticket.controllers.HomeController
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.Configuration
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.inject.bind
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._
import org.scalatest.mockito.MockitoSugar
import scala.concurrent.duration._
import scala.concurrent.Await
//import org.scalatestplus.mockito
import movieticket.service.CatalogService
import org.mockito.Mockito._

import scala.concurrent.Future

@RunWith(classOf[JUnitRunner])
class HomeControllerSpec extends PlaySpec
  with MockitoSugar
  with GuiceOneAppPerSuite
  with TestValues {

  import scala.concurrent.ExecutionContext.Implicits.global
  private implicit lazy val materializer: Materializer = app.materializer

  private val config = Configuration(ConfigFactory.load("application.conf"))

  //  private val BasketHeaderKey = config.get[String]("play.filters.headers.x-basket-id")

  //  private val mockBasketService = mock[BasketService]
  private val mockCatalogService = mock[CatalogService]

  private val controller = new GuiceApplicationBuilder()
    .configure(config)
    //    .overrides(bind[BasketService].toInstance(mockBasketService))
    .overrides(bind[CatalogService].toInstance(mockCatalogService))
    .build()
    .injector
    .instanceOf[HomeController]

  "A HomeController" should {

    "return a list of items in the avail catalog" in {

      when(mockCatalogService.listAvail).thenReturn(Future(catalogList))
      val result = controller.listAvailTicket(FakeRequest(GET, "/avail"))
      assert(status(result) ==  OK)
      assert(contentAsJson(result) ==  Json.toJson(catalogList))
    }

    "return a list of items in the total catalog" in {

      when(mockCatalogService.listCatalog).thenReturn(Future(catalogList))
      val result = controller.listTicket(FakeRequest(GET, "/ticket"))
      assert(status(result) ==  OK)
      assert(contentAsJson(result) ==  Json.toJson(catalogList))
    }

    "should return buyinfo" in {
      when(mockCatalogService.listBuyinfo).thenReturn(Future(infolist))
      val result = controller.listBuyinfo(FakeRequest(GET, "/ticket"))
      assert(status(result) ==  OK)
      assert(contentAsJson(result) ==  Json.toJson(infolist))
    }

    "should find item with id" in {
     //val result = controller.ticketIsNotFill(1)(FakeRequest(PUT, "/buy/1"))
      when(controller.findTicketById(1)).thenReturn(Future(ticket))
      val result = controller.findTicketById(1)
      assert(Await.result(result,2.seconds) == ticket)
     // assert(status(result) ==  OK)
      //assert
      // ontentAsJson(result) ==  Json.toJson(ticket))
    }

//    "should update item with id"{
//      val result= controller.ticketIsNotFill(1)(FakeRequest(PUT, "/buy/1"))
//      if (status(result) == OK) 0 else 1
//
//    }

  }
}
