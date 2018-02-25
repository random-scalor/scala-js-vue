package scalajs.vue.demo.server.util

import akka.http.scaladsl.model.MediaTypes
import akka.http.scaladsl.model.ContentType
import akka.http.scaladsl.model.HttpCharsets
import akka.http.scaladsl.marshalling._

import scalacss.DevDefaults._

trait ScalaCssSupport {

  implicit def scalaCssMarshaller : ToEntityMarshaller[ StyleSheet.Standalone ] =
    Marshaller.StringMarshaller.wrap( MediaTypes.`text/css` )( _.render )

}

object ScalaCssSupport extends ScalaCssSupport
