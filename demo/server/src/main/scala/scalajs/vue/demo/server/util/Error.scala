package scalajs.vue.demo.server.util

object Error {

  object Throw {

    def apply( message : String ) = throw new RuntimeException( message )

  }

}
