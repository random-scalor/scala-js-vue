package scalajs.vue.tags

import org.scalajs.dom
import scalatags.JsDom.all._
import scala.scalajs.js.annotation._

trait VueRouterTags extends Any {

  // vue-router
  object router {

    val to_ = attr( "to" )

    val link : CustomTag = tag( "router-link" )
    def link( path : String ) : CustomTag = link( to_ := path )

    val name_ = attr( "name" )

    val view : CustomTag = tag( "router-view" )
    def view( name : String ) : CustomTag = view( name_ := name )

  }

}
