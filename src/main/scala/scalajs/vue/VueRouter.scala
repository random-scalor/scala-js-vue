package scalajs.vue

import scala.scalajs.js
import org.scalajs.dom._
import scala.scalajs.js.annotation._

// https://router.vuejs.org/en/

@JSGlobal //
@js.native
class VueRouter extends js.Object {
  import VueRouter._

  def this( options : js.Object ) = this()

  def push( location : String ) : Unit = js.native
  def push( location : js.Dynamic ) : Unit = js.native

  def replace( location : String ) : Unit = js.native
  def replace( location : js.Dynamic ) : Unit = js.native

  def addRoutes( routes : js.Array[ RouteConfig ] ) : Unit = js.native

  val app : Vue = js.native
  val mode : String = js.native
  val currentRoute : Route = js.native

}

@JSGlobal
@js.native
object VueRouter extends js.Object {

  @js.native
  trait Vue extends js.Object {
    val $route : Route = js.native
    val $router : VueRouter = js.native
  }

  @js.native
  class Route extends js.Object {
    val name : String = js.native
    val path : String = js.native
  }

  @js.native
  class RouteConfig extends js.Object {
    val name : String = js.native
    val path : String = js.native
    val component : Vue = js.native
    val children : js.Array[ RouteConfig ] = js.native
  }

  @js.native
  class RouterOptions extends js.Object {
    val routes : js.Array[ RouteConfig ] = js.native
  }

}
