package scalajs.vue.tags

import org.scalajs.dom
import scalatags.JsDom
import scalatags.JsDom.all._
import scala.scalajs.js.annotation._

trait BootstrapVueTags extends Any {

  object bs {

    val show = attr( "show" ).empty

    val dismissible = attr( "dismissible" ).empty

    val variant = attr( "variant" )

    object variants {
      val primary = "primary"
      val secondary = "secondary"
      val success = "success"
      val danger = "danger"
      val warning = "warning"
      val info = "info"
      val light = "light"
      val dark = "dark"
    }

    object vb {
      val modal = attr( "v-b-modal" )
    }

    val alert = tag( "b-alert" )

    val badge = tag( "b-badge" )

    object button {
      def apply( args : JsDom.Modifier* ) = A( args : _* )
      private val A = tag( "b-button" )
      val group = tag( "b-button-group" )
      val toolbar = tag( "b-button-toolbar" )
    }

    val dropdown = tag( "b-dropdown" )

    object form {
      def apply( args : JsDom.Modifier* ) = A( args : _* )
      private val A = tag( "b-form" )
      //
      val group = tag( "b-form-group" )
      val row = tag( "b-form-row" )
      val text = tag( "b-form-text" )
      val feedback = tag( "b-form-feedback" )
      //
      val file = tag( "b-form-file" )
      val input = tag( "b-form-input" )
      val radio = tag( "b-form-radio" )
      val select = tag( "b-form-select" )
      val checkbox = tag( "b-form-checkbox" )
      val textarea = tag( "b-form-textarea" )
    }

    object layout {
      val container = tag( "b-container" )
      val col = tag( "b-col" )
      val row = tag( "b-fow" )
      val form_row = form.row
    }

    val modal = tag( "b-modal" )

    object nav {
      def apply( args : JsDom.Modifier* ) = A( args : _* )
      private val A = tag( "b-nav" )
      val item = tag( "b-nav-item" )
      val text = tag( "b-nav-next" )
      val dropdown = tag( "b-nav-item-dropdown" )

    }

    object navbar {
      def apply( args : JsDom.Modifier* ) = A( args : _* )
      private val A = tag( "b-navbar" )
      val nav = tag( "b-navbar-nav" )
      val brand = tag( "b-navbar-brand" )
      val toggle = tag( "b-navbar-toggle" )
    }

    object pagination {
      def apply( args : JsDom.Modifier* ) = A( args : _* )
      private val A = tag( "b-pagination" )
      val nav = tag( "b-pagination-nav" )
    }

    val popover = tag( "popover" )

    object progress {
      def apply( args : JsDom.Modifier* ) = A( args : _* )
      private val A = tag( "b-progress" )
      val bar = tag( "b-progress-bar" )
    }

    val tab = tag( "b-tab" )
    val tabs = tag( "b-tabs" )

    object table {

    }

    val tooltip = tag( "b-tooltip" )

  }

}
