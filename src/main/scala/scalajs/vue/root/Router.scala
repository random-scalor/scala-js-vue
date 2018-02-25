package scalajs.vue.root

import scalajs.vue.VueRouter

import scala.scalajs.js
import scala.scalajs.js.Dynamic._
import scalajs.vue.util.ObjectExtra._

/**
 * VueRouter router descriptor.
 */
trait Router {

  def routerOptions : js.Object = literal()

  lazy val rootRouter = new VueRouter( routerOptions )

}

object Router {

}
