package scalajs.vue.part

import scalajs.vue.Vue
import scala.scalajs.js
import scala.scalajs.js.Any._
import scala.scalajs.js.Dynamic._
import scala.scalajs.js.annotation._

import scalajs.vue.Vuex

import scalajs.vue.util.ObjectExtra._

import scalajs.vue.meta.Macro._

/**
 *  Vue.js + Vuex.js: model + view combined part.
 */
trait Vuez extends Any with Component with Module {

  def componentComputed : js.Object = literal()
  def componentMethods : js.Object = literal()

  override def computed = mergeWith( componentComputed, moduleComputed )
  override def methods = mergeWith( componentMethods, moduleMethods )

}
