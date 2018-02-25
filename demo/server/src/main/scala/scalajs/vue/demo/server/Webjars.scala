package scalajs.vue.demo.server

import akka.http.scaladsl.server.RequestContext
import org.webjars.WebJarAssetLocator
import scala.util.Try
import scala.util.Success
import scalajs.vue.demo.server.util.Error.Throw

/**
 *  Resource mapping.
 */
trait Webjars extends Reference with View {

  import Webjars._
  import Reference._

  /**
   *  Public webjars assets.
   */
  lazy val webjarsTags = {
    referenceWebjars.list.map { entry =>
      resourcePath( entry ).getOrElse(
        Throw( s"Missing webjar entry: ${entry}" )
      )
      val path = publicPath( entry )
      entry.kind match {
        case WebjarEntry.javaScript   => javaScript( path )
        case WebjarEntry.styleSheet   => styleSheet( path )
        case WebjarEntry.shortcutIcon => shortcutIcon( path )
      }
    }
  }

}

/**
 *  Resource mapping.
 */
object Webjars extends Reference {

  import Reference._

  val root = referenceRoot

  val webjarsLocator = new WebJarAssetLocator()

  /**
   *  Public asset path in browser.
   */
  def publicPath( name : String, path : String ) : String = {
    s"${root}/${name}/${path}"
  }

  def publicPath( entry : WebjarEntry ) : String = {
    import entry._
    publicPath( name, path )
  }

  /**
   *  Internal asset resource in class path.
   */
  def resourcePath( name : String, path : String ) : Option[ String ] = {
    Try( Option( webjarsLocator.getFullPath( name, path ) ) ).toOption.flatten
  }

  def resourcePath( entry : WebjarEntry ) : Option[ String ] = {
    import entry._
    resourcePath( name, path )
  }

}
