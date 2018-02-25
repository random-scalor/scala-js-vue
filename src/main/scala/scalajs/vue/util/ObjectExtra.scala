package scalajs.vue.util

import scala.scalajs.js
import scala.scalajs.js.Any._
import scala.scalajs.js.Dynamic._
import scala.scalajs.js.annotation._

class ObjectExtra extends js.Object {

  def toLiteral() : js.Object = ObjectExtra.toLiteral( this )

  def mergeWith( that : js.Object ) : js.Object = ObjectExtra.mergeWith( this, that )

}

object ObjectExtra {

  def appendTo( src : js.Object, dst : js.Object ) : Unit = {
    val srcDyn = src.asInstanceOf[ js.Dynamic ]
    val dstDyn = dst.asInstanceOf[ js.Dynamic ]
    for ( prop <- js.Object.properties( src ) ) {
      if ( prop != "constructor" ) {
        dstDyn.updateDynamic( prop )( srcDyn.selectDynamic( prop ) )
      }
    }
  }

  // FIXME make recursive
  def toLiteral( obj : js.Object ) : js.Object = {
    val result = js.Dynamic.literal()
    appendTo( obj, result )
    result
  }

  // will be called
  def mergeWith( one : js.Object, two : js.Object ) : js.Object = {
    val result = js.Dynamic.literal()
    appendTo( one, result )
    appendTo( two, result )
    result
  }

  // will be inlined
  def mergeWith( list : js.Object* ) : js.Object = {
    val result = js.Dynamic.literal()
    for ( obj <- list ) {
      appendTo( obj, result )
    }
    result
  }

}
