// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/huihuanzhao/Desktop/scalafinal/finalgit/ticketagency/ticketagency1/conf/routes
// @DATE:Fri Dec 06 09:00:54 EST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package movieticket.controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def login(username:String, password:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "login/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("username", username)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("password", password)))
    }
  
    // @LINE:27
    def listticketbymvid(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "seats/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:36
    def createUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "user")
    }
  
    // @LINE:33
    def listspec(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "listspec/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:18
    def listAvailTicket(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "avail")
    }
  
    // @LINE:21
    def listBuyinfo(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "buyinfo")
    }
  
    // @LINE:9
    def listMovies(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "movie")
    }
  
    // @LINE:12
    def listUsers(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "user")
    }
  
    // @LINE:39
    def ticketIsNotFill(id:Int, username:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "buy/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("username", username)))
    }
  
    // @LINE:30
    def listall(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "all")
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:15
    def listTicket(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ticket")
    }
  
  }


}
