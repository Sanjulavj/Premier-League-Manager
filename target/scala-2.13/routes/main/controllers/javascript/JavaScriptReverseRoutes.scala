// @GENERATOR:play-routes-compiler
// @SOURCE:E:/OOP/CW play2/oopbackend/conf/routes
// @DATE:Mon Jan 04 10:15:39 IST 2021

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:12
package controllers.javascript {

  // @LINE:12
  class ReversePremierLeagueController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def randomMatch: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PremierLeagueController.randomMatch",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/randomMatch"})
        }
      """
    )
  
    // @LINE:12
    def listClubs: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PremierLeagueController.listClubs",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/clubs"})
        }
      """
    )
  
    // @LINE:14
    def listMatches: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PremierLeagueController.listMatches",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/matches"})
        }
      """
    )
  
  }


}
