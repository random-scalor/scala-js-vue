package scalajs.vue.demo.server

import prickle._

import scalatags.Text.all._

import scala.reflect.ClassTag

import akka.http.scaladsl.server.RequestContext
import java.nio.charset.StandardCharsets

trait View {

  def javaScript( path : String ) = script( src := path, tpe := "text/javascript" )

  def styleSheet( path : String ) = link( href := path, rel := "stylesheet", media := "screen" )

  def shortcutIcon( path : String ) = link( href := path, rel := "shortcut icon" )

}

object View extends View with Webjars {

  def apply(
    title :   String          = "",
    header :  Seq[ Modifier ] = Seq.empty,
    content : Seq[ Modifier ] = Seq.empty,
    footer :  Seq[ Modifier ] = Seq.empty
  )( implicit ctx : RequestContext ) =
    html(
      head(
        meta( charset := StandardCharsets.UTF_8.name.toLowerCase ),
        webjarsTags
      ),
      header,
      body( content ),
      footer
    )

}
