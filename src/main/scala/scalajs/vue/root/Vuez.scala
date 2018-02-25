package scalajs.vue.root

import scalajs.vue.part

import scala.scalajs.js
import scala.scalajs.js.Dynamic._
import scalajs.vue.util.ObjectExtra._

/**
 * Vue.js + Vuex.js root combo part.
 */
trait Vuez extends part.Vuez with Component with Module with Router {

  override def componentOptions = mergeWith(
    super.componentOptions,
    literal(
      store  = rootModule,
      router = rootRouter
    )
  )

  /**
   * Register part combo: component with model.
   */
  def register( vuez : part.Vuez ) : Unit = {
    registerModule( vuez )
    registerComponent( vuez )
  }

}
