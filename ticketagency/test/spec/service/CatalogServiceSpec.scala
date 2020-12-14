package spec.service


import com.typesafe.config.ConfigFactory
import movieticket.service.CatalogService
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{MustMatchers, WordSpecLike}
import play.api.Configuration
import play.modules.reactivemongo.ReactiveMongoApi
import org.scalatest.mockito.MockitoSugar
import javax.inject.{Inject, Named}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import play.api.inject.Injector
import play.api.inject.guice.GuiceApplicationBuilder
@RunWith(classOf[JUnitRunner])
class CatalogServiceSpec extends TestActorKit
  with MockitoSugar
  with MustMatchers
  with WordSpecLike
  with ScalaFutures
  with TestValues {

  import scala.concurrent.ExecutionContext.Implicits.global

  private val config = Configuration(ConfigFactory.load("application.conf"))

  private lazy val appBuilder: GuiceApplicationBuilder = new GuiceApplicationBuilder()
  private lazy val injector: Injector = appBuilder.injector()
  private val reactiveMongoApi: ReactiveMongoApi = injector.instanceOf[ReactiveMongoApi]
  "A CatalogService" must {

    "return all the items in the catalog" in {

      val catalogActorRef = testActorRef(catalogList)

        val a = new CatalogService(catalogActorRef,reactiveMongoApi,config)
        val result = a.listCatalog
        result.futureValue mustEqual catalogList
      }
    }
}