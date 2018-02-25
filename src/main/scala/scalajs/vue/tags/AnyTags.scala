package scalajs.vue.tags

import scalatags.JsDom.all._
import scala.scalajs.js.annotation._
import scala.language.implicitConversions
import scala.scalajs.js.Any.fromString

case class Name[ T ]( val name : String ) extends AnyVal {
  override def toString = name
}
case class ListName[ T ]( val name : String ) extends AnyVal {
  override def toString = name
}

trait AnyTags extends Any
  with VueTags
  with VueRouterTags
  with BootstrapVueTags {

  val item = Name( "item" );
  val itemList = ListName( "item_list" );

}

//@JSExportAll
//@JSExportTopLevel( "AnyTags" )
object AnyTags extends AnyTags {

  import scala.language.implicitConversions

  import scala.scalajs.js

  implicit def CustomTag_JsAny( tags : CustomTag ) : js.Any = {
    tags.toString()
  }

}
