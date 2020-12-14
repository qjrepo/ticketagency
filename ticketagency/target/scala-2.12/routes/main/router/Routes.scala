// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/huihuanzhao/Desktop/scalafinal/finalgit/ticketagency/ticketagency1/conf/routes
// @DATE:Fri Dec 06 09:00:54 EST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: movieticket.controllers.HomeController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: movieticket.controllers.HomeController
  ) = this(errorHandler, HomeController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """movieticket.controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """movie""", """movieticket.controllers.HomeController.listMovies"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user""", """movieticket.controllers.HomeController.listUsers"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ticket""", """movieticket.controllers.HomeController.listTicket"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """avail""", """movieticket.controllers.HomeController.listAvailTicket"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """buyinfo""", """movieticket.controllers.HomeController.listBuyinfo"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login/""" + "$" + """username<[^/]+>/""" + "$" + """password<[^/]+>""", """movieticket.controllers.HomeController.login(username:String, password:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """seats/""" + "$" + """id<[^/]+>""", """movieticket.controllers.HomeController.listticketbymvid(id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """all""", """movieticket.controllers.HomeController.listall"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """listspec/""" + "$" + """id<[^/]+>""", """movieticket.controllers.HomeController.listspec(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user""", """movieticket.controllers.HomeController.createUser"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """buy/""" + "$" + """id<[^/]+>/""" + "$" + """username<[^/]+>""", """movieticket.controllers.HomeController.ticketIsNotFill(id:Int, username:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val movieticket_controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val movieticket_controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "movieticket.controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val movieticket_controllers_HomeController_listMovies1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("movie")))
  )
  private[this] lazy val movieticket_controllers_HomeController_listMovies1_invoker = createInvoker(
    HomeController_0.listMovies,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "movieticket.controllers.HomeController",
      "listMovies",
      Nil,
      "GET",
      this.prefix + """movie""",
      """ list all movie information""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val movieticket_controllers_HomeController_listUsers2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user")))
  )
  private[this] lazy val movieticket_controllers_HomeController_listUsers2_invoker = createInvoker(
    HomeController_0.listUsers,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "movieticket.controllers.HomeController",
      "listUsers",
      Nil,
      "GET",
      this.prefix + """user""",
      """ list all user information in database""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val movieticket_controllers_HomeController_listTicket3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ticket")))
  )
  private[this] lazy val movieticket_controllers_HomeController_listTicket3_invoker = createInvoker(
    HomeController_0.listTicket,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "movieticket.controllers.HomeController",
      "listTicket",
      Nil,
      "GET",
      this.prefix + """ticket""",
      """ list all ticket information""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val movieticket_controllers_HomeController_listAvailTicket4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("avail")))
  )
  private[this] lazy val movieticket_controllers_HomeController_listAvailTicket4_invoker = createInvoker(
    HomeController_0.listAvailTicket,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "movieticket.controllers.HomeController",
      "listAvailTicket",
      Nil,
      "GET",
      this.prefix + """avail""",
      """ list all available seat & movie information""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val movieticket_controllers_HomeController_listBuyinfo5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("buyinfo")))
  )
  private[this] lazy val movieticket_controllers_HomeController_listBuyinfo5_invoker = createInvoker(
    HomeController_0.listBuyinfo,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "movieticket.controllers.HomeController",
      "listBuyinfo",
      Nil,
      "GET",
      this.prefix + """buyinfo""",
      """ list all purchase information""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val movieticket_controllers_HomeController_login6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login/"), DynamicPart("username", """[^/]+""",true), StaticPart("/"), DynamicPart("password", """[^/]+""",true)))
  )
  private[this] lazy val movieticket_controllers_HomeController_login6_invoker = createInvoker(
    HomeController_0.login(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "movieticket.controllers.HomeController",
      "login",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """login/""" + "$" + """username<[^/]+>/""" + "$" + """password<[^/]+>""",
      """ make sure userinformation fits the data in mongodb""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val movieticket_controllers_HomeController_listticketbymvid7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("seats/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val movieticket_controllers_HomeController_listticketbymvid7_invoker = createInvoker(
    HomeController_0.listticketbymvid(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "movieticket.controllers.HomeController",
      "listticketbymvid",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """seats/""" + "$" + """id<[^/]+>""",
      """ get avail ticket by actor""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val movieticket_controllers_HomeController_listall8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("all")))
  )
  private[this] lazy val movieticket_controllers_HomeController_listall8_invoker = createInvoker(
    HomeController_0.listall,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "movieticket.controllers.HomeController",
      "listall",
      Nil,
      "GET",
      this.prefix + """all""",
      """ get all 1 million record""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val movieticket_controllers_HomeController_listspec9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("listspec/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val movieticket_controllers_HomeController_listspec9_invoker = createInvoker(
    HomeController_0.listspec(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "movieticket.controllers.HomeController",
      "listspec",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """listspec/""" + "$" + """id<[^/]+>""",
      """ get avail seat for special movie from 1 million record""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val movieticket_controllers_HomeController_createUser10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user")))
  )
  private[this] lazy val movieticket_controllers_HomeController_createUser10_invoker = createInvoker(
    HomeController_0.createUser,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "movieticket.controllers.HomeController",
      "createUser",
      Nil,
      "POST",
      this.prefix + """user""",
      """ user register""",
      Seq()
    )
  )

  // @LINE:39
  private[this] lazy val movieticket_controllers_HomeController_ticketIsNotFill11_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("buy/"), DynamicPart("id", """[^/]+""",true), StaticPart("/"), DynamicPart("username", """[^/]+""",true)))
  )
  private[this] lazy val movieticket_controllers_HomeController_ticketIsNotFill11_invoker = createInvoker(
    HomeController_0.ticketIsNotFill(fakeValue[Int], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "movieticket.controllers.HomeController",
      "ticketIsNotFill",
      Seq(classOf[Int], classOf[String]),
      "PUT",
      this.prefix + """buy/""" + "$" + """id<[^/]+>/""" + "$" + """username<[^/]+>""",
      """ buy ticket and update the seat situation in database""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case movieticket_controllers_HomeController_index0_route(params@_) =>
      call { 
        movieticket_controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:9
    case movieticket_controllers_HomeController_listMovies1_route(params@_) =>
      call { 
        movieticket_controllers_HomeController_listMovies1_invoker.call(HomeController_0.listMovies)
      }
  
    // @LINE:12
    case movieticket_controllers_HomeController_listUsers2_route(params@_) =>
      call { 
        movieticket_controllers_HomeController_listUsers2_invoker.call(HomeController_0.listUsers)
      }
  
    // @LINE:15
    case movieticket_controllers_HomeController_listTicket3_route(params@_) =>
      call { 
        movieticket_controllers_HomeController_listTicket3_invoker.call(HomeController_0.listTicket)
      }
  
    // @LINE:18
    case movieticket_controllers_HomeController_listAvailTicket4_route(params@_) =>
      call { 
        movieticket_controllers_HomeController_listAvailTicket4_invoker.call(HomeController_0.listAvailTicket)
      }
  
    // @LINE:21
    case movieticket_controllers_HomeController_listBuyinfo5_route(params@_) =>
      call { 
        movieticket_controllers_HomeController_listBuyinfo5_invoker.call(HomeController_0.listBuyinfo)
      }
  
    // @LINE:24
    case movieticket_controllers_HomeController_login6_route(params@_) =>
      call(params.fromPath[String]("username", None), params.fromPath[String]("password", None)) { (username, password) =>
        movieticket_controllers_HomeController_login6_invoker.call(HomeController_0.login(username, password))
      }
  
    // @LINE:27
    case movieticket_controllers_HomeController_listticketbymvid7_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        movieticket_controllers_HomeController_listticketbymvid7_invoker.call(HomeController_0.listticketbymvid(id))
      }
  
    // @LINE:30
    case movieticket_controllers_HomeController_listall8_route(params@_) =>
      call { 
        movieticket_controllers_HomeController_listall8_invoker.call(HomeController_0.listall)
      }
  
    // @LINE:33
    case movieticket_controllers_HomeController_listspec9_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        movieticket_controllers_HomeController_listspec9_invoker.call(HomeController_0.listspec(id))
      }
  
    // @LINE:36
    case movieticket_controllers_HomeController_createUser10_route(params@_) =>
      call { 
        movieticket_controllers_HomeController_createUser10_invoker.call(HomeController_0.createUser)
      }
  
    // @LINE:39
    case movieticket_controllers_HomeController_ticketIsNotFill11_route(params@_) =>
      call(params.fromPath[Int]("id", None), params.fromPath[String]("username", None)) { (id, username) =>
        movieticket_controllers_HomeController_ticketIsNotFill11_invoker.call(HomeController_0.ticketIsNotFill(id, username))
      }
  }
}
