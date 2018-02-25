package scalajs.vue.demo.server

import akka.actor.ActorSystem
import akka.actor.ExtendedActorSystem
import akka.actor.Extension
import akka.actor.Props
import akka.event.Logging
import scala.collection.JavaConverters._
import akka.event.LogSource
import com.typesafe.scalalogging.LazyLogging
import akka.actor.ExtensionId
import akka.actor.ExtensionIdProvider
import akka.actor.ExtendedActorSystem
import akka.stream.ActorMaterializer
import akka.http.scaladsl.Http

class ServerProvider( system : ExtendedActorSystem )
  extends Extension
  with Reference {

  implicit def httpSystem = system
  implicit def httpContext = system.dispatcher

  implicit val materializer = ActorMaterializer()

  private val log = Logging( system, classOf[ ServerProvider ] )

  val bind = referenceBind

  lazy val bindingFuture = {
    Http().bindAndHandle( Router(), bind.addr, bind.port )
  }

  protected def initialize() = {
    log.info( s"Initialize @ ${bind}" )
    bindingFuture // bind
  }

  protected def terminate() = {
    log.info( s"Terminate @ ${bind}" )
    bindingFuture.flatMap( _.unbind() )
  }

  system.registerOnTermination( terminate )
  initialize()

}

object ServerExtension
  extends ExtensionId[ ServerProvider ]
  with ExtensionIdProvider {
  // akka registration
  override def lookup = ServerExtension
  // akka call back
  override def createExtension( system : ExtendedActorSystem ) = new ServerProvider( system )
  // java api
  override def get( system : ActorSystem ) : ServerProvider = super.get( system )
}
