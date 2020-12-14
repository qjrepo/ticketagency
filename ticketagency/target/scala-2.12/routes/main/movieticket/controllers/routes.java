// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/huihuanzhao/Desktop/scalafinal/finalgit/ticketagency/ticketagency1/conf/routes
// @DATE:Fri Dec 06 09:00:54 EST 2019

package movieticket.controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final movieticket.controllers.ReverseHomeController HomeController = new movieticket.controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final movieticket.controllers.javascript.ReverseHomeController HomeController = new movieticket.controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
  }

}
