package scalajs.vue.demo.server.util

import scalatags.text
import scalatags.Text
import scalatags.Escaping
import scalatags.Text.TypedTag

import akka.http.scaladsl.model.MediaTypes
import akka.http.scaladsl.model.ContentType
import akka.http.scaladsl.model.HttpCharsets
import akka.http.scaladsl.marshalling._

trait ScalaTagsSupport {

  val hasPretty = true

  implicit def scalaTagsMarshaller : ToEntityMarshaller[ TypedTag[ String ] ] =
    Marshaller.StringMarshaller.wrap( MediaTypes.`text/html` ) { t =>
      if ( hasPretty ) {
        val strb = new StringBuilder
        prettyWriteTo( t, strb, 0, 2 )
        strb.toString()
      } else {
        t.toString()
      }
    }

  def prettyWriteTo( t : Text.TypedTag[ String ], strb : StringBuilder, depth : Int, step : Int ) : Unit = {

    val indent = " " * depth * step
    val builder = new text.Builder()
    t.build( builder )
    val attrs = builder.attrs.take( builder.attrIndex )
    val children = builder.children.take( builder.childIndex ).toList

    def escape( s : String ) : String = {
      val sb = new StringBuilder
      Escaping.escape( s, sb )
      sb.toString()
    }

    strb ++= indent += '<' ++= t.tag

    attrs.foreach { attr =>
      strb ++= " "
      strb ++= attr._1
      strb ++= "=\""
      attr._2.appendAttrValue( strb )
      strb ++= "\""
    }

    if ( children.isEmpty && t.void ) {
      strb ++= "/>"
    } else {
      strb ++= ">"
      for ( c <- children ) {
        c match {
          case t : TypedTag[ String ] =>
            strb ++= "\n"
            prettyWriteTo( t, strb, depth + 1, step )
          case any =>
            strb ++= "\n" ++= " " * ( depth + 1 ) * step
            any.writeTo( strb )
        }
      }
      strb ++= "\n" ++= indent ++= "</" ++= t.tag += '>'
    }
  }

}

object ScalaTagsSupport extends ScalaTagsSupport
