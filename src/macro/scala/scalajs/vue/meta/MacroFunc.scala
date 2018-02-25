package scalajs.vue.meta

import scala.scalajs.js
import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context
import scala.annotation.tailrec
import scala.reflect.api.materializeWeakTypeTag

class MacroFunc( val c : Context ) extends MacroContext {

  import c.universe._

  def macroPropOf( member : c.Expr[ Any ] ) : c.Expr[ String ] = {

    val name = extractName( member.tree ).decodedName.toString

    val result = q"$name"
    info( s"${showCode( result )}" )
    c.Expr[ String ]( result )
  }

  def macroFuncOf( member : c.Expr[ Any ] ) : c.Expr[ String ] = {
    // val ctx = memberContext( member ); import ctx._

    val ( name, param ) = member.tree match {
      case Apply( func, args ) =>
        val list = args.drop( 1 ) // drop 'state'
        val name = renderName( func )
        val param = if ( list.length == 0 ) {
          ""
        } else {
          renderTerm( list( 0 ) )
        }
        ( name, param )
      case _ =>
        fail( s"need method apply: '${member.tree}'" )
    }

    val func = s"$name($param)"
    val result = q"$func"
    info( s"${result}" )
    c.Expr[ String ]( result )
  }

  def macroCommitOf( member : c.Expr[ Any ] ) : c.Expr[ Any ] = {
    val ctx = memberContext( member ); import ctx._

    val methodXform : List[ Tree ] = memberMethods.map { tree =>
      val DefDef( mods, name, tparams, vparamss, tpt, rhs ) = tree
      val params = vparamss( 0 ) // solo value
      val argDef = params.drop( 1 )( 0 ) // drop 'state'
      val ValDef( argMods, argName, argTpt, argRhs ) = argDef
      val nameText = name.decodedName.toString

      val method = q"""
        def $name($argName : $argTpt)(implicit context : Context) = {
          context.commit($nameText, $argName)
        }
      """
      method
    }

    val result = q"""
    class Commit extends AnyRef {
      ..$methodXform
    }
    new Commit()
    """

    info( s"${showCode( result )}" )

    c.Expr[ Any ]( result )
  }

  def macroDispatchOf( member : c.Expr[ Any ] ) : c.Expr[ Any ] = {
    val ctx = memberContext( member ); import ctx._

    val methodXform : List[ Tree ] = memberMethods.map { tree =>
      val DefDef( mods, name, tparams, vparamss, tpt, rhs ) = tree
      //      val params = vparamss( 0 ) // solo value
      //      val argDef = params.drop( 1 )( 0 ) // drop 'state'
      //      val ValDef( argMods, argName, argTpt, argRhs ) = argDef
      val nameText = name.decodedName.toString

      val method = q"""
        def $name()(implicit context : Context) = {
          context.dispatch($nameText)
        }
      """
      method
    }

    val result = q"""
    class Dispatch extends AnyRef {
      ..$methodXform
    }
    new Dispatch()
    """

    info( s"${showCode( result )}" )

    c.Expr[ Any ]( result )
  }

  def macroMethodList( member : c.Expr[ Any ] ) : c.Expr[ js.Array[ String ] ] = {
    val ctx = memberContext( member ); import ctx._

    val methodNames = memberMethods.map( tree => renderName( tree ) )

    val result = q"""
      js.Array[String] ( ..$methodNames )
    """

    if ( methodNames.isEmpty ) {
      warn( s"no methods in '$memberName'" )
    } else {
      info( s"${showCode( result )}" )
    }

    c.Expr[ js.Array[ String ] ]( result )
  }

}
