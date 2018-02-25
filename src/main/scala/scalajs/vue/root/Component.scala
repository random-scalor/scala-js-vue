package scalajs.vue.root

import scalajs.vue.Vue
import scalajs.vue.part
import scala.scalajs.js.Dynamic._
import scalajs.vue.util.ObjectExtra._

/**
 *  Vue root view descriptor.
 */
trait Component extends part.Component {

  /**
   * Register part component.
   */
  def registerComponent( component : part.Component ) : Unit = {
    Vue.component( component.tagName, component.componentOptions )
  }

  /**
   *  Vue root view instance.
   */
  lazy val rootComponent : Vue = new Vue( componentOptions )

}
