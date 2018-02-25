package scalajs.vue.demo.client.part

import scalajs.vue.part.Component

import scala.scalajs.js
import scala.scalajs.js.Any._
import scala.scalajs.js.Dynamic._
import scala.scalajs.js.annotation._

import scalatags.JsDom.all._
import scalajs.vue.tags.AnyTags._
import scalajs.vue.part.Vuez

import scalajs.vue.meta.Macro._
import scalajs.vue.Vuex

import scalajs.vue.util.ObjectExtra._

object Status extends Vuez {

  class State extends js.Object {
    var count : Int = 10
  }

  override def state = new State()

  override object getters extends js.Object {
    def value( state : State ) = state.count
  }

  override object actions extends js.Object {
    def operatate( implicit context : Context ) = {
      commit.statusInc( 10 )
      js.timers.setTimeout( 1000 ) {
        commit.statusDec( 10 )
        dispatch.continue()
      }
    }
    def continue( implicit context : Context ) = {
      println(s"XXX continue")
    }
  }

  override object mutations extends js.Object {
    def statusInc( state : State, step : Int ) = state.count += step
    def statusDec( state : State, step : Int ) = state.count -= step
  }

  override val commit = commitOf( mutations )
  override val dispatch = dispatchOf( actions )
  override val gettersList = methodList( getters )
  override val actionsList = methodList( actions )
  override val mutationsList = methodList( mutations )

  override def data() = literal(
    todo_list = js.Array( "item 1", "item 2", "item 3" )
  )

  override object componentComputed extends js.Object {
    def hello() = "hello"
  }

  override object componentMethods extends js.Object {
    def dump() = {
      for ( prop <- js.Object.properties( this ) ) {
        println( s"prop ${prop}" )
      }
    }
  }

  import componentComputed._
  import componentMethods._

  override def template = div(
    h3( "status" ),
    p( "hello=", span( v.text := propOf( hello() ) ) ),
    button( "dump", v.on.click := funcOf( dump() ) ),
    p( "count=", span( v.text := propOf( getters.value( null ) ) ) ),
    button( "operate", v.on.click := funcOf( actions.operatate( null ) ) ),
    button( "increase", v.on.click := funcOf( mutations.statusInc( null, 3 ) ) ),
    button( "decrease", v.on.click := funcOf( mutations.statusDec( null, 3 ) ) ),
    ol(
      li( v.for_ := "todo in todo_list", "{{ todo }}" )
    )
  ).toString

}
