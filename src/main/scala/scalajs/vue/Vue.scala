package scalajs.vue

import scala.scalajs.js
import org.scalajs.dom._
import scala.scalajs.js.annotation._

// https://vuejs.org/v2/guide/

@JSGlobal
@js.native
class Vue extends js.Object
  with Vuex.Vue
  with VueRouter.Vue {

  def this( obj : js.Object ) = this()

  import Vue._

  // https://vuejs.org/v2/api/#Instance-Properties

  val $el : raw.Element = js.native
  val $data : js.Dynamic = js.native
  val $props : js.Dynamic = js.native
  val $options : js.Dynamic = js.native

  val $root : Vue = js.native
  val $parent : Vue = js.native
  val $children : js.Array[ Vue ] = js.native

  val $ : js.Dynamic = js.native
  val $$ : js.Dynamic = js.native

  // https://vuejs.org/v2/api/#Instance-Methods-Data

  def $watch( expOrFn : js.Any, callback : WatchHandler ) : UnwatchObject = js.native
  def $watch( expOrFn : js.Any, callback : WatchHandler, options : js.Any ) : UnwatchObject = js.native

  def $set( target : js.Any, key : js.Any, value : js.Any ) : Unit = js.native

  def $delete( target : js.Any, key : js.Any ) : Unit = js.native

  // https://vuejs.org/v2/api/#Instance-Methods-Events

  def $emit( event : String ) : Unit = js.native
  def $emit( event : String, args : js.Any ) : Unit = js.native

  def $on( event : String, callback : js.Function ) : Unit = js.native

  def $once( event : String, callback : js.Function ) : Unit = js.native

  def $off() : Unit = js.native
  def $off( event : String ) : Unit = js.native
  def $off( event : String, callback : js.Function ) : Unit = js.native

  // https://vuejs.org/v2/api/#Instance-Methods-Lifecycle

  def $mount( elementOrSelector : js.Any ) : Vue = js.native
  def $destroy( destroy : Boolean = false ) : Unit = js.native
  def $nextTick( callback : js.Function ) : Unit = js.native

}

@JSGlobal
@js.native
object Vue extends js.Object { // VueConstructor

  type WatchHandler = js.Function2[ _, _, Unit ]

  @js.native
  trait UnwatchObject extends js.Object {
    def unwatch : Unit = js.native
  }

  @js.native
  trait ComponentOptions extends js.Object {
    def name : String = js.native
  }

  @js.native
  trait VueComponent extends js.Object {
    def options : ComponentOptions = js.native
  }

  // https://vuejs.org/v2/guide/render-function.html

  @js.native
  trait CreateElement extends js.Function3[ //
  String, // tag 
  js.Dynamic, // data
  js.Array[ js.Dynamic ], // children 
  Unit ]

  // https://vuejs.org/v2/api/#Global-Config

  @js.native
  object config extends js.Object {
    val silent : Boolean = js.native
    val devtools : Boolean = js.native
    val errorHandler : js.Function = js.native
    val warnHandler : js.Function = js.native
  }

  // https://vuejs.org/v2/api/#Global-API

  def extend( obj : js.Any ) : Vue = js.native

  def nextTick( func : js.Function ) : Unit = js.native

  def directive( id : String ) : js.Any = js.native
  def directive( id : String, definition : js.Dynamic ) : Unit = js.native
  def directive( id : String, definition : js.ThisFunction ) : Unit = js.native

  def elementDirective( id : String, definition : js.Any ) : Unit = js.native
  def elementDirective( id : String, definition : js.ThisFunction ) : Unit = js.native

  def filter( id : String ) : js.Any = js.native
  def filter( id : String, func : js.Function ) : Unit = js.native

  def component( id : String, definition : js.Object ) : Vue = js.native
  def component( id : String, definition : js.Function ) : Vue = js.native

  def transition( id : String ) : js.Any = js.native
  def transition( id : String, definition : js.Any ) : js.Any = js.native

  def partial( id : String ) : js.Any = js.native
  def partial( id : String, template : String ) : js.Any = js.native

  def use( plugin : js.Any ) : js.Any = js.native
  def use( plugin : js.Any, args : js.Any* ) : js.Any = js.native

  def set( target : js.Any, key : js.Any, value : js.Any ) : Unit = js.native

  def delete( target : js.Any, key : js.Any ) : Unit = js.native

  def mixin( mixin : js.Object ) : Unit = js.native

  def compile( template : String ) : js.Function = js.native

  def version : String = js.native

}
