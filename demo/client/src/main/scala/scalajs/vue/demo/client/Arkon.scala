package scalajs.vue.demo.client

import scala.scalajs.js.annotation._
import scalajs.vue.root
import scalajs.vue.tags.AnyTags._
import scalatags.JsDom.all._
import org.scalajs.dom

/**
 * Vue.js single page application.
 */
trait Arkon extends root.Vuez {

  import bs._

  register( part.Status )

  override lazy val template : String = div(
    alert( "hello kitty", variant := variants.primary, cls := "m-1", dismissible, show ),
    button( "danger button", variant := variants.danger, cls := "m-1", disabled ),
    part.Status.htmlTag()
  ).toString

}

/**
 * Vue.js application module initializer.
 */
@JSExportAll
@JSExportTopLevel( "scalajs.vue.demo.client.Arkon" )
object Arkon extends Arkon {

  import dom._

  /**
   * Vue.js root mount.
   */
  def body( mountId : String ) = {
    val mount = document.createElement( "div" )
    mount.id = mountId
    val body = document.createElement( "body" )
    body.appendChild( mount )
    body.asInstanceOf[ raw.HTMLElement ]
  }

  /**
   * Application entry point.
   */
  def main( args : Array[ String ] ) : Unit = {
    val name = classOf[ Arkon ].getName
    val mountId = name.replaceAll( "[.$]", "_" )
    val argsLine = args.mkString( "( ", ", ", " )" )
    println( s"Module initializer @ ${name} ${argsLine}" )
    document.body = body( mountId )
    rootComponent.$mount( "#" + mountId )
  }

}
