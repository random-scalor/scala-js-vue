package scalajs.vue.root

import scalajs.vue.part
import scalajs.vue.Vuex

import scala.scalajs.js
import scala.scalajs.js.Dynamic._
import scalajs.vue.util.ObjectExtra._

/**
 *  Vuex root module descriptor.
 */
trait Module extends part.Module {
  import Module._

  def modulePlugins : js.Array[ Vuex.Plugin ] = js.Array()

  override def moduleOptions = mergeWith(
    super.moduleOptions,
    literal(
      plugins = modulePlugins
    )
  )

  /**
   * Register part module.
   */
  def registerModule(
    module :  part.Module,
    options : js.Object   = registerOptions
  ) = {
    rootModule.registerModule( module.namespace, module.moduleOptions, options )
  }

  /**
   *  Vuex root module instance.
   */
  lazy val rootModule = new Vuex.Store( moduleOptions )

}

object Module {

  val registerOptions = literal(
    preserveState = false
  )

}
