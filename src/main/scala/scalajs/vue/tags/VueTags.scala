package scalajs.vue.tags

import scalatags.JsDom.all._

trait VueTags extends Any {

  object v {

    /**
     *  Custom directive.
     */
    def apply( drective : String ) = attr( s"v-$drective" )

    object on {
      def apply( name : String ) = attr( s"v-on:$name" )
      val click = apply( "click" )
    }

    val text = attr( "v-text" )

    def bind( name : String ) = attr( s"v-bind:$name" )

    val if_ = attr( "v-if" )

    val for_ = attr( "v-for" )

    //    def forEach[ T ]( item : Name[ T ], list : ListName[ T ] ) = for_ := s"$item in $list"

  }

}
