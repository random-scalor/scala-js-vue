package scalajs.vue.demo.server.page

import akka.stream.Materializer
import akka.actor.ActorSystem
import akka.http.scaladsl.server.Route
import scalajs.vue.demo.server.Page

trait ArkonPage extends Page {

  override def apply() //
  ( implicit sys : ActorSystem, mat : Materializer ) : Route = pathEnd {
    get {
      extractRequestContext { implicit ctx =>
        complete( ArkonView() )
      }
    }
  }

}

object ArkonPage extends ArkonPage
