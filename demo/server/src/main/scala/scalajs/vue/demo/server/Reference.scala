package scalajs.vue.demo.server

import com.typesafe.config.ConfigFactory
import com.typesafe.config.Config

import scala.collection.JavaConverters._

/**
 * Server configuration.
 */
trait Reference {

  import Reference._

  val referenceKey = "scala-js-vue-demo-server"

  def referenceConfig = ConfigFactory.load().getConfig( referenceKey )

  def referenceBind = Bind( referenceConfig )

  def referenceRoot = referenceConfig.getString( "root" )

  def referenceWebjars = Webjars( referenceConfig )

}

object Reference {

  case class Bind( addr : String, port : Int )

  object Bind {
    def apply( config : Config ) : Bind = {
      val bind = config.getConfig( "bind" )
      Bind(
        addr = bind.getString( "addr" ),
        port = bind.getInt( "port" )
      )
    }
  }

  /**
   * Public webjars resources.
   */
  case class Webjars( list : Seq[ WebjarEntry ] )

  object Webjars {
    def apply( config : Config ) : Webjars = {
      val webjars = config.getConfigList( "webjars" )
      Webjars(
        list = webjars.asScala.map( WebjarEntry( _ ) )
      )
    }
  }

  case class WebjarEntry( kind : String, name : String, path : String )

  object WebjarEntry {

    val javaScript = "javascript"
    val styleSheet = "stylesheet"
    val shortcutIcon = "shortcut-icon"

    def apply( config : Config ) : WebjarEntry = {
      WebjarEntry(
        kind = config.getString( "kind" ),
        name = config.getString( "name" ),
        path = config.getString( "path" )
      )
    }
  }

}
