package scalajs.vue.demo.server.page

import scalatags.Text.all._
import akka.http.scaladsl.server.RequestContext
import scalajs.vue.demo.server.View

trait ArkonView extends View {

  def apply( root : String = "arkon" )( implicit ctx : RequestContext ) = View( //
  // content = Seq( div( id := root ) ),
  // footer  = Seq( script( s"Arkon.init('$root')" ) )
  )

}

object ArkonView extends ArkonView
