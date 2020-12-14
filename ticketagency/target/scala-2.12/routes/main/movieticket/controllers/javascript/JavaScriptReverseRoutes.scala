// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/huihuanzhao/Desktop/scalafinal/finalgit/ticketagency/ticketagency1/conf/routes
// @DATE:Fri Dec 06 09:00:54 EST 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:6
package movieticket.controllers.javascript {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "movieticket.controllers.HomeController.login",
      """
        function(username0,password1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("username", username0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("password", password1))})
        }
      """
    )
  
    // @LINE:27
    def listticketbymvid: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "movieticket.controllers.HomeController.listticketbymvid",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "seats/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:36
    def createUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "movieticket.controllers.HomeController.createUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user"})
        }
      """
    )
  
    // @LINE:33
    def listspec: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "movieticket.controllers.HomeController.listspec",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "listspec/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:18
    def listAvailTicket: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "movieticket.controllers.HomeController.listAvailTicket",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "avail"})
        }
      """
    )
  
    // @LINE:21
    def listBuyinfo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "movieticket.controllers.HomeController.listBuyinfo",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "buyinfo"})
        }
      """
    )
  
    // @LINE:9
    def listMovies: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "movieticket.controllers.HomeController.listMovies",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "movie"})
        }
      """
    )
  
    // @LINE:12
    def listUsers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "movieticket.controllers.HomeController.listUsers",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user"})
        }
      """
    )
  
    // @LINE:39
    def ticketIsNotFill: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "movieticket.controllers.HomeController.ticketIsNotFill",
      """
        function(id0,username1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "buy/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("username", username1))})
        }
      """
    )
  
    // @LINE:30
    def listall: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "movieticket.controllers.HomeController.listall",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "all"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "movieticket.controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:15
    def listTicket: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "movieticket.controllers.HomeController.listTicket",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ticket"})
        }
      """
    )
  
  }


}
