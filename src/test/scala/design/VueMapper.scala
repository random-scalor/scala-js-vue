package design

import org.scalajs.dom._
import scala.scalajs.js.annotation._
import scalajs.vue.Vue._

// // https://github.com/vuejs/vue/blob/dev/types/

@JSExportTopLevel( "VueMapper" )
object VueMapper {

  @JSExportAll
  case class Template( text : String ) extends AnyVal {
    override def toString = text
  }

  @JSExportAll
  case object Template {
    import scalatags.Text.all._
    def from( tags : Modifier ) : Template = Template( tags.toString() )
    val empty = Template( "" )
  }

}
