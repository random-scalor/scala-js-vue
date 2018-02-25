package scalajs.vue.meta

import scala.language.experimental.macros
import scala.reflect.api.materializeWeakTypeTag

trait Name {
  import scala.language.experimental.macros

  def nameOf( expr : Any ) : String = macro NameImpl.nameOf

  def nameOf[ T ]( expr : T => Any ) : String = macro NameImpl.nameOf

  def nameOfType[ T ] : String = macro NameImpl.nameOfType[ T ]

  def qualifiedNameOfType[ T ] : String = macro NameImpl.qualifiedNameOfType[ T ]
}

object Name extends Name

object NameImpl {
  import scala.annotation.tailrec
  import scala.reflect.macros.whitebox.Context

  def nameOf( c : Context )( expr : c.Expr[ Any ] ) : c.Expr[ String ] = {
    import c.universe._

    def prefix( message : String ) = s"Name macro: $message"
    def info( message : String ) = c.info( c.enclosingPosition, prefix( message ), true )
    def warn( message : String ) = c.warning( c.enclosingPosition, prefix( message ) )
    def fail( message : String ) = c.abort( c.enclosingPosition, prefix( message ) )

    @tailrec
    def extract( tree : c.Tree ) : c.Name = tree match {
      case Ident( n )           => n
      case Select( _, n )       => n
      case Function( _, body )  => extract( body )
      case Block( _, expr )     => extract( expr )
      case Apply( func, _ )     => extract( func )
      case TypeApply( func, _ ) => extract( func )
      case _                    => fail( s"Unsupported expression: $expr" )
    }

    val name = extract( expr.tree ).decodedName.toString()

    val result = q"$name"
    info( s"${showCode( result )}" )
    c.Expr[ String ]( result )

  }

  def nameOfType[ T ]( ctx : Context )( implicit tag : ctx.WeakTypeTag[ T ] ) : ctx.Expr[ String ] = {
    import ctx.universe._

    val name = showRaw( tag.tpe.typeSymbol.name )

    ctx.Expr[ String ]( q"$name" )

  }

  def qualifiedNameOfType[ T ]( ctx : Context )( implicit tag : ctx.WeakTypeTag[ T ] ) : ctx.Expr[ String ] = {
    import ctx.universe._

    val name = showRaw( tag.tpe.typeSymbol.fullName )

    ctx.Expr[ String ]( q"$name" )

  }

}
