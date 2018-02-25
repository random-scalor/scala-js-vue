package design

import scala.scalajs.js
import org.scalajs.dom._
import scala.scalajs.js.annotation._
import scala.language.implicitConversions
import scala.collection.Seq
import scala.scalajs.js.Any.fromFunction1
import scala.scalajs.js.Any.fromString
import scalajs.vue.Vue

@JSExportTopLevel( "VueTypes" )
object VueTypes {

  //  type ¬[A] = A => Nothing
  //  type ¬¬[A] = ¬[¬[A]]
  //  type ∨[T, U] = ¬[¬[T] with ¬[U]]
  //  type |∨|[T, U] = { type λ[X] = ¬¬[X] <:< (T ∨ U) }

  type ElementType = String // |∨| raw.Element
  type ComponentType = Vue // |∨| FunctionalComponentOptions
  type DirectiveType = DirectiveOptions // |∨| DirectiveFunction

  //  implicit def `ComponentOptions => Dynamic`(opts: ComponentOptions): js.Dynamic = {
  //     import opts._
  //     literal(
  //         el = el,
  //         template = template,
  //         components = components,
  //         directives = directives,
  //     )
  //  }

  @JSExportAll
  class ComponentOptions(

    // https://vuejs.org/v2/api/#Options-DOM
    val el :       ElementType = "",
    val template : String      = "",

    // https://vuejs.org/v2/api/#Options-Data

    // https://vuejs.org/v2/api/#Options-Lifecycle-Hooks

    // https://vuejs.org/v2/api/#Options-Assets
    val components : Seq[ ComponentType ] = Seq(),
    val directives : Seq[ DirectiveType ] = Seq()

  // https://vuejs.org/v2/api/#Options-Composition

  // https://vuejs.org/v2/api/#Options-Misc

  ) // extends js.Object

  @JSExportAll
  class FunctionalComponentOptions( // TODO
  ) // extends js.Object

  @JSExportAll
  class VNode( // TODO
  ) // extends js.Object

  @JSExportAll
  class VNodeDirective(
    val name :       String,
    val value :      Any    = "",
    val oldValue :   Any    = "",
    val expression : Any    = "",
    val arg :        String = "",
    val modifiers :  Any    = Seq()
  // { [key: string]: boolean },
  ) // extends js.Object

  type Binding = VNodeDirective
  type NodeNew = VNode
  type NodeOld = VNode

  @JSExportAll
  trait DirectiveFunction extends Function4[ raw.Element, Binding, NodeNew, NodeOld, Unit ]

  @JSExportAll
  class DirectiveOptions(
    val bind :             DirectiveFunction = ???,
    val inserted :         DirectiveFunction = ???,
    val update :           DirectiveFunction = ???,
    val componentUpdated : DirectiveFunction = ???,
    val unbind :           DirectiveFunction = ???
  ) // extends js.Object

}
