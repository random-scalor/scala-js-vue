package scalajs.vue.part

import scalajs.vue.Vue
import scalajs.vue.tags.AnyTags._

import scala.scalajs.js
import scala.scalajs.js.Dynamic._

import scalatags.JsDom.all._

import scalajs.vue.part.Component._
import scalajs.vue.Vue.VueComponent
import scalajs.vue.util.Namer

/**
 *  Vue.js component descriptor.
 *  
 *  https://vuejs.org/v2/guide/components.html
 */
trait Component extends Any with Event {

  def name = this.getClass.getSimpleName

  def tagName = Namer.convertCamelKebab( name )

  def htmlTag = tag( tagName )

  def data : js.Object = literal()

  def props = js.Array[ String ]()

  def template : String = div().toString()

  def components : js.Object = literal()

  def computed : js.Object = literal()

  def methods : js.Object = literal()

  /**
   *  Constructor parameters.
   */
  def componentOptions : js.Object = literal(
    data  = data _,
    props = props,

    //
    computed = computed,
    methods  = methods,

    //
    watch       = literal(),
    template    = template,
    components  = components,
    directives  = literal(),
    transitions = literal(),
    filters     = literal(),

    // event
    beforeCreate  = beforeCreate _,
    created       = created _,
    beforeDestroy = beforeDestroy _,
    destroyed     = destroyed _,
    beforeMount   = beforeMount _,
    mounted       = mounted _,
    beforeUpdate  = beforeUpdate _,
    updated       = updated _,
    activated     = activated _,
    deactivated   = deactivated _
  )

}

object Component {

  trait Model {

  }

  trait Event {
    def beforeCreate() = {}
    def created() = {}
    def beforeDestroy() = {}
    def destroyed() = {}
    def beforeMount() = {}
    def mounted() = {}
    def beforeUpdate() = {}
    def updated() = {}
    def activated() = {}
    def deactivated() = {}
  }

}
