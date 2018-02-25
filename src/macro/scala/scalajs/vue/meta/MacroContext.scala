package scalajs.vue.meta

import scala.annotation.tailrec
import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context

trait MacroContext {

  val c : Context
  
  import c.universe._

  def prefix( message : String ) = s"Vue.macro: ${message}"
  def info( message : String ) = c.info( c.enclosingPosition, prefix( message ), true )
  def warn( message : String ) = c.warning( c.enclosingPosition, prefix( message ) )
  def fail( message : String ) = c.abort( c.enclosingPosition, prefix( message ) )

  @tailrec
  final def extractName( tree : c.Tree ) : c.Name = tree match {
    case Ident( name )        => name
    case Select( _, name )    => name
    case Function( _, body )  => extractName( body )
    case Block( _, expr )     => extractName( expr )
    case Apply( func, _ )     => extractName( func )
    case TypeApply( func, _ ) => extractName( func )
    case _                    => fail( s"Unsupported expression: $tree" )
  }

  def renderName( tree : Tree ) = {
    tree.symbol.name.decodedName.toString
  }

  def renderTerm( tree : Tree ) = {
    tree.toString
  }

  def enclosingClassBody : List[ Tree ] = c.enclosingClass match {
    case ClassDef( _, _, _, Template( _, _, body ) ) => body
    case ModuleDef( _, _, Template( _, _, body ) )   => body
    case klaz =>
      fail( s"Wrong enclosing class: ${klaz.getClass}" )
      Nil
  }

  def findMemberBody( treeList : List[ Tree ], named : String ) : List[ Tree ] = {
    def has( name : TermName ) = name.decodedName.toString == named
    val result = treeList.collectFirst {
      case ValDef( _, name, _, rhs ) if has( name )                    => List( rhs )
      case DefDef( _, name, _, _, _, rhs ) if has( name )              => List( rhs )
      case ModuleDef( _, name, Template( _, _, body ) ) if has( name ) => body
    }
    result.getOrElse( List( q"" ) )
  }

  def findMemberMethods( treeList : List[ Tree ] ) : List[ Tree ] = {
    def has( tree : Tree ) = tree.symbol.isMethod && !tree.symbol.isConstructor
    val result = treeList.collect {
      case tree : DefDef if has( tree ) => tree
    }
    result
  }

  def memberContext( member : c.Expr[ Any ] ) = new {
    val classBody = enclosingClassBody
    val memberName = renderName( member.tree )
    val memberBody = findMemberBody( classBody, memberName )
    val memberMethods = findMemberMethods( memberBody )
  }

}
