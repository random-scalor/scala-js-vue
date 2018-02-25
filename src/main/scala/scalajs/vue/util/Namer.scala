package scalajs.vue.util

import scala.scalajs.js

object Namer {

  /**
   * Convert SomeName to some-name.
   */
  def convertCamelKebab( name : String ) : String = {
    name
      .replaceAll( "([a-z])([A-Z]+)", "$1-$2" )
      .toLowerCase()
  }

}
