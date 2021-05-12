// @GENERATOR:play-routes-compiler
// @SOURCE:E:/OOP/CW play2/oopbackend/conf/routes
// @DATE:Mon Jan 04 10:15:39 IST 2021

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReversePremierLeagueController PremierLeagueController = new controllers.ReversePremierLeagueController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReversePremierLeagueController PremierLeagueController = new controllers.javascript.ReversePremierLeagueController(RoutesPrefix.byNamePrefix());
  }

}
