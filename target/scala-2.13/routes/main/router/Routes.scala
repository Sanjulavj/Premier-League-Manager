// @GENERATOR:play-routes-compiler
// @SOURCE:E:/OOP/CW play2/oopbackend/conf/routes
// @DATE:Mon Jan 04 10:15:39 IST 2021

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:12
  PremierLeagueController_0: controllers.PremierLeagueController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:12
    PremierLeagueController_0: controllers.PremierLeagueController
  ) = this(errorHandler, PremierLeagueController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, PremierLeagueController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/clubs""", """controllers.PremierLeagueController.listClubs"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/matches""", """controllers.PremierLeagueController.listMatches"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/randomMatch""", """controllers.PremierLeagueController.randomMatch"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:12
  private[this] lazy val controllers_PremierLeagueController_listClubs0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/clubs")))
  )
  private[this] lazy val controllers_PremierLeagueController_listClubs0_invoker = createInvoker(
    PremierLeagueController_0.listClubs,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PremierLeagueController",
      "listClubs",
      Nil,
      "GET",
      this.prefix + """api/clubs""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_PremierLeagueController_listMatches1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/matches")))
  )
  private[this] lazy val controllers_PremierLeagueController_listMatches1_invoker = createInvoker(
    PremierLeagueController_0.listMatches,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PremierLeagueController",
      "listMatches",
      Nil,
      "GET",
      this.prefix + """api/matches""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_PremierLeagueController_randomMatch2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/randomMatch")))
  )
  private[this] lazy val controllers_PremierLeagueController_randomMatch2_invoker = createInvoker(
    PremierLeagueController_0.randomMatch,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PremierLeagueController",
      "randomMatch",
      Nil,
      "GET",
      this.prefix + """api/randomMatch""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:12
    case controllers_PremierLeagueController_listClubs0_route(params@_) =>
      call { 
        controllers_PremierLeagueController_listClubs0_invoker.call(PremierLeagueController_0.listClubs)
      }
  
    // @LINE:14
    case controllers_PremierLeagueController_listMatches1_route(params@_) =>
      call { 
        controllers_PremierLeagueController_listMatches1_invoker.call(PremierLeagueController_0.listMatches)
      }
  
    // @LINE:16
    case controllers_PremierLeagueController_randomMatch2_route(params@_) =>
      call { 
        controllers_PremierLeagueController_randomMatch2_invoker.call(PremierLeagueController_0.randomMatch)
      }
  }
}
