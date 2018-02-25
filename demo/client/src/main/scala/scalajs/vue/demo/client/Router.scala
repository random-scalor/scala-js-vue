package scalajs.vue.demo.client

import scala.scalajs.js
import scala.scalajs.js.Dynamic._
import scala.scalajs.js.annotation._
import scalajs.vue.VueRouter
import scalajs.vue.tags.AnyTags._
import scalajs.vue.demo.client.Arkon

trait Router {

}

//@JSExportAll
//case class Route(
//   path: String = "/invalid",
//   component: ComponentOptions = new ComponentOptions(el="invalid"),
//)

//@JSExportAll
//@JSExportTopLevel("Router")
object Router {

  //

  import Arkon._

  lazy val routes = js.Array[ js.Dynamic ]( //    market.route,
  )

  lazy val router = new VueRouter(
    literal(
      // https://router.vuejs.org/en/essentials/history-mode.html
      //mode = "history",
      routes = routes
    )
  )

}
