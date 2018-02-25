package scalajs.vue.demo.client

import scala.language.reflectiveCalls
import scala.scalajs.js
import scala.scalajs.js.Any._
import scala.scalajs.js.Dynamic._
import scala.scalajs.js.annotation._
import scalajs.vue.root
import scalajs.vue.util.ObjectExtra._
import scalajs.vue.meta.Macro._

/** root store */
object Store extends root.Module {

  class State extends js.Object {
    var count : Int = 10
  }

  override def state = new State

  override object getters extends js.Object {
    def count( state : State ) = state.count
    def abracadabra( state : State ) = "hello-kitty"
  }

  override object actions extends js.Object {
    def operation( implicit context : Context ) = {
      commit.increment( 10 )
      js.timers.setTimeout( 1000 ) {
        commit.decrement( 10 )
      }
    }
  }

  override object mutations extends js.Object {
    def increment( state : State, step : Int ) = state.count += step
    def decrement( state : State, step : Int ) = state.count -= step
  }

  override def modules = literal()

  def test = {
    //    dispatch.operation()
  }

  override val commit = commitOf( mutations )
  //  override val dispatch = dispatchOf( actions )
  override val gettersList = methodList( getters )
  override val actionsList = methodList( actions )
  override val mutationsList = methodList( mutations )

}
