package scalajs.vue.part

import scala.scalajs.js
import scala.scalajs.js.Any._
import scala.scalajs.js.Dynamic._
import scala.scalajs.js.annotation._

import scalajs.vue.Vuex

import scalajs.vue.util.ObjectExtra._

import scalajs.vue.meta.Macro._
import scalajs.vue.util.Namer

/**
 *  Vuex.js module descriptor.
 *
 *  https://vuex.vuejs.org/en/modules.html
 */
trait Module extends Any {

  import Module._

  type State <: js.Object // require: class State
  type Getters <: js.Object // require: type Getters = getters.type
  type Context = Vuex.ActionContext[ State, Getters ]
  type Store = Vuex.Store

  /**
   * Module name space.
   */
  def namespace = Namer.convertCamelKebab( this.getClass.getSimpleName )

  def namespaced = namespace != ""

  /**
   *  Map `component.getter` into `component.$store.getters('namespace/getter')`
   */
  def mapGetters : js.Object = if ( namespaced ) {
    Vuex.mapGetters( namespace, gettersList )
  } else {
    Vuex.mapGetters( gettersList )
  }

  /**
   *  Map `component.action()` to `component.$store.dispatch('namespace/action')`
   */
  def mapActions : js.Object = if ( namespaced ) {
    Vuex.mapActions( namespace, actionsList )
  } else {
    Vuex.mapActions( actionsList )
  }

  /**
   * Map `component.mutation()` to `component.$store.commit('namespace/mutation')`
   */
  def mapMutations : js.Object = if ( namespaced ) {
    Vuex.mapMutations( namespace, mutationsList )
  } else {
    Vuex.mapMutations( mutationsList )
  }

  /**
   *  Expose store state as `component.property` https://vuejs.org/v2/api/#computed
   */
  def moduleComputed : js.Object = mapGetters

  /**
   *  Expose store modificators as `component.function()` https://vuejs.org/v2/api/#methods
   */
  def moduleMethods : js.Object = mergeWith( mapActions, mapMutations )

  // https://vuex.vuejs.org/en/api.html

  /**
   * Generate initial state instance.
   */
  def state : State = empty_js_object.asInstanceOf[ State ]

  /**
   * Define getters for the store.
   */
  def getters : js.Object = empty_js_object

  /**
   * Define actions for the store.
   */
  def actions : js.Object = empty_js_object

  /**
   * Define mutations for the store
   */
  def mutations : js.Object = empty_js_object

  /**
   * An object containing sub modules to be merged into the store.
   */
  def modules : js.Object = empty_js_object

  /**
   *  Constructor parameters.
   */
  def moduleOptions : js.Object = literal(
    namespaced = namespaced,
    state      = state,
    getters    = toLiteral( getters ),
    actions    = toLiteral( actions ),
    mutations  = toLiteral( mutations ),
    modules    = toLiteral( modules )
  )

  // Macro expansion:

  /**
   *  Generate $store.commit facade.
   */
  protected def commit : AnyRef = empty_object
  /**
   *  Generate $store.dispatch facade.
   */
  protected def dispatch : AnyRef = empty_object
  /**
   *  Generate getters methods names.
   */
  protected def gettersList : js.Array[ String ] = empty_js_array
  /**
   *  Generate actions methods names.
   */
  protected def actionsList : js.Array[ String ] = empty_js_array
  /**
   *  Generate mutations methods names.
   */
  protected def mutationsList : js.Array[ String ] = empty_js_array

}

object Module {

  val empty_object = new Object
  val empty_js_object = literal()
  val empty_js_array = js.Array[ String ]()

  // macro expansion example

  trait Macro extends Module {
    //    override val commit = commitOf( mutations )
    //    override val dispatch = dispatchOf( actions )
    //    override val gettersList = methodList( getters )
    //    override val actionsList = methodList( actions )
    //    override val mutationsList = methodList( mutations )
  }

}
