package scalajs.vue.meta

import scala.language.experimental.macros
import scala.scalajs.js

/**
 *  Vue.js macro support.
 */
trait Macro {

  /**
   *  Generate JS property access.
   */
  def propOf( member : Any ) : String = macro MacroFunc.macroPropOf

  /**
   *  Generate JS function application.
   */
  def funcOf( member : Any ) : String = macro MacroFunc.macroFuncOf

  /**
   *  Generate Vuex.js commit object.
   */
  def commitOf( member : Any ) : Any = macro MacroFunc.macroCommitOf

  /**
   *  Generate Vuex.js dispatch object.
   */
  def dispatchOf( member : Any ) : Any = macro MacroFunc.macroDispatchOf

  /**
   *  Extract methods from Vuex.js object.
   */
  def methodList( member : Any ) : js.Array[ String ] = macro MacroFunc.macroMethodList

}

object Macro extends Macro
