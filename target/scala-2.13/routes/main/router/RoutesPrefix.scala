// @GENERATOR:play-routes-compiler
// @SOURCE:E:/OOP/CW play2/oopbackend/conf/routes
// @DATE:Mon Jan 04 10:15:39 IST 2021


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
