package scalajs.vue.demo.server

import akka.actor.ActorSystem
import akka.stream.Materializer
import akka.http.scaladsl.server.Route
import org.webjars.WebJarAssetLocator
import akka.http.scaladsl.model.StatusCodes

object Router extends Page {

  def apply()( implicit sys : ActorSystem, mat : Materializer ) : Route = {

    path( "arkon" ) {
      println( s"arkon" )
      page.ArkonPage()
    } ~
      path( Webjars.root / Segment / Remaining ) { ( name, path ) =>
        println( s"${Webjars.root}: ${name}/${path}" )
        Webjars.resourcePath( name, path ) match {
          case Some( resource ) => getFromResource( resource )
          case None             => complete( StatusCodes.NotFound )
        }
      }

  }

}
