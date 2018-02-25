package scalajs.vue

import scala.scalajs.js
import org.scalajs.dom._
import scala.scalajs.js.annotation._

// https://vuex.vuejs.org/en/
@JSGlobal
@js.native
class Vuex extends js.Object {
  import Vuex._

  def this( obj : js.Object ) = this()

}

// https://vuex.vuejs.org/en/api.html
@JSGlobal
@js.native
object Vuex extends js.Object {

  @js.native
  trait Vue extends js.Object {
    val $store : Store = js.native
  }

  type State = js.Object

  @js.native
  class Store extends js.Object {

    def this( storeOptions : js.Object ) = this()

    def state : State = js.native

    def commit( name : String ) : Unit = js.native
    def commit( name : String, payload : js.Object ) : Unit = js.native
    def commit( name : String, payload : js.Object, options : js.Object ) : Unit = js.native

    def dispatch( name : String ) : Unit = js.native
    def dispatch( name : String, payload : js.Object ) : Unit = js.native
    def dispatch( name : String, payload : js.Object, options : js.Object ) : Unit = js.native

    def getters( options : js.Object ) : js.Object = js.native

    def registerModule( path : String, module : js.Object, options : js.Object ) : Unit = js.native
    def registerModule( path : js.Array[ String ], module : js.Object, options : js.Object ) : Unit = js.native

    def unregisterModule( path : String ) : Unit = js.native
    def unregisterModule( path : js.Array[ String ] ) : Unit = js.native

  }

  type Plugin = js.Function1[ Store, Unit ]

  @js.native
  trait Module[ State ] extends js.Object {
    def namespaced : Boolean
    def state : State
    //  getters?: GetterTree<S, R>;
    //  actions?: ActionTree<S, R>;
    //  mutations?: MutationTree<S>;
    //  modules?: ModuleTree<R>;
  }

  @js.native
  trait StoreOptions[ State ] extends js.Object {
    def state : State
    //  getters?: GetterTree<S, S>
    //  actions?: ActionTree<S, S>;
    //  mutations?: MutationTree<S>;
    //  modules?: ModuleTree<S>;
    def plugins : js.Array[ Plugin ];
    //  strict?: boolean;
  }

  @js.native
  trait ActionContext[ State, Getters ] extends js.Object {
    def state : State = js.native
    def getters : Getters = js.native
    def rootState : js.Object = js.native
    def rootGetters : js.Object = js.native
    def commit( mutation : String ) : Unit = js.native
    def commit( mutation : String, payload : js.Any ) : Unit = js.native
    def dispatch( action : String ) : js.Promise[ _ ] = js.native
    def dispatch( action : String, payload : js.Any ) : js.Promise[ _ ] = js.native
  }

  // https://vuex.vuejs.org/en/api.html
  def replaceState( state : State ) : Unit = js.native

  // https://vuex.vuejs.org/en/state.html
  def mapState( namespace : String, map : js.Object ) : js.Object = js.native
  def mapState( namespace : String, map : js.Array[ String ] ) : js.Object = js.native

  // https://vuex.vuejs.org/en/actions.html
  def mapActions( map : js.Object ) : js.Object = js.native
  def mapActions( map : js.Array[ String ] ) : js.Object = js.native
  def mapActions( namespace : String, map : js.Object ) : js.Object = js.native
  def mapActions( namespace : String, map : js.Array[ String ] ) : js.Object = js.native

  // https://vuex.vuejs.org/en/getters.html
  def mapGetters( map : js.Object ) : js.Object = js.native
  def mapGetters( map : js.Array[ String ] ) : js.Object = js.native
  def mapGetters( namespace : String, map : js.Object ) : js.Object = js.native
  def mapGetters( namespace : String, map : js.Array[ String ] ) : js.Object = js.native

  // https://vuex.vuejs.org/en/mutations.html
  def mapMutations( map : js.Object ) : js.Object = js.native
  def mapMutations( map : js.Array[ String ] ) : js.Object = js.native
  def mapMutations( namespace : String, map : js.Object ) : js.Object = js.native
  def mapMutations( namespace : String, map : js.Array[ String ] ) : js.Object = js.native

}
