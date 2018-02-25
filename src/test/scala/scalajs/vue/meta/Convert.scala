package scalajs.vue.meta

import scala.language.experimental.macros

trait Convert {

  type State

  //  implicit def extract_state_method_name1( expr : ( State ) => Unit ) : String = macro NameImpl.nameOf
  //  implicit def extract_state_method_name2( expr : ( State, _ ) => Unit ) : String = macro NameImpl.nameOf

}
