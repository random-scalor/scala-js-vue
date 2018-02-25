package test

import akka.actor.ActorSystem

import scalajs.vue.demo.server.ServerExtension

import scala.concurrent.Await
import scala.concurrent.duration._

/**
 * Interactive Eclipse test application.
 */
object Main {

  def main( args : Array[ String ] ) : Unit = {
    
    val name = "tester"
    val system = ActorSystem( name )
    val extension = ServerExtension( system )
    
    sys.addShutdownHook {
      system.terminate()
      Await.result( system.whenTerminated, 3 seconds )
    }
    
    while ( true ) {
      println( s"${name} @ ${getClass.getName}" )
      Thread.sleep( 9000 )
    }
    
  }

}
