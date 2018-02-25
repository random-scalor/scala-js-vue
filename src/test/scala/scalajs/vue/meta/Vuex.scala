package scalajs.vue.meta

import scala.scalajs.js
import scala.annotation.StaticAnnotation
import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context
import scala.reflect.api.materializeTypeTag
import scala.reflect.api.materializeWeakTypeTag

object Vuex {

  class Mutation extends StaticAnnotation

  /** build methods list from "methods" value object */
  def gettersListMacro : js.Array[ String ] = macro VuexImpl.gettersList

  /** build actions list from "actions" value object */
  def actionsListMacro : js.Array[ String ] = macro VuexImpl.actionsList

  /** build mutations list from "mutations" value object */
  def mutationsListMacro : js.Array[ String ] = macro VuexImpl.mutationsList

}

class VuexImpl( val c : Context ) {
  import scala.annotation.tailrec
  import c.universe._

  def gettersList : c.Expr[ js.Array[ String ] ] = {
    buildMethodsList( "getters" )
  }

  def actionsList : c.Expr[ js.Array[ String ] ] = {
    buildMethodsList( "actions" )
  }

  def mutationsList : c.Expr[ js.Array[ String ] ] = {
    buildMethodsList( "mutations" )
  }

  def prefix( message : String ) = s"Vuex macro: $message"
  def info( message : String ) = c.info( c.enclosingPosition, prefix( message ), true )
  def warn( message : String ) = c.warning( c.enclosingPosition, prefix( message ) )
  def fail( message : String ) = c.abort( c.enclosingPosition, prefix( message ) )

  def hasAnnotation( method : MethodSymbol, tpe : Type ) = {
    method.annotations.map( _.tree.tpe.toString() ).contains( tpe.toString() )
  }

  def memberList( face : Type ) = {
    val faceMembers = face.members.sorted
    val objectMembers = face.companion match {
      case NoType => List[ Symbol ]()
      case _      => face.companion.members
    }
    faceMembers ++ objectMembers
  }

  def enclosingClassBody : List[ Tree ] = c.enclosingClass match {
    case ClassDef( _, _, _, Template( _, _, body ) ) => body
    case ModuleDef( _, _, Template( _, _, body ) )   => body
    case klaz =>
      fail( s"Wrong enclosing class: ${klaz.getClass}" )
      Nil
  }

  def findNamed( treeList : List[ Tree ], named : String ) : List[ Tree ] = {
    def has( name : TermName ) = name.decodedName.toString() == named
    val result = treeList.collectFirst {
      case ValDef( _, name, _, rhs ) if has( name )                    => List( rhs )
      case DefDef( _, name, _, _, _, rhs ) if has( name )              => List( rhs )
      case ModuleDef( _, name, Template( _, _, body ) ) if has( name ) => body
    }
    result.getOrElse( List( q"" ) )
  }

  def findMethod( treeList : List[ Tree ] ) : List[ Tree ] = {
    def has( tree : Tree ) = tree.symbol.isMethod && !tree.symbol.isConstructor
    val result = treeList.collect {
      case tree : DefDef if has( tree ) => tree
    }
    result
  }

  def buildMethodsList( memberName : String ) : c.Expr[ js.Array[ String ] ] = {

    val body = enclosingClassBody
    val named = findNamed( body, memberName )
    val calls = findMethod( named )
    val names = calls.map( _.symbol.name.decodedName.toString() )

    val result = q"""
      js.Array[String] ( ..$names )
    """

    if ( names.isEmpty ) {
      warn( s"no methods in '$memberName'" )
    } else {
      info( s"${showCode( result )}" )
    }

    c.Expr[ js.Array[ String ] ]( result )
  }

  //  def vuexMutationsXXX[ T : c.WeakTypeTag ] : c.Expr[ js.Array[ String ] ] = {
  //
  //    val face = weakTypeOf[ T ]
  //
  //    val faceMembers = face.members.sorted
  //
  //    val objectMembers = face.companion match {
  //      case NoType => List[ Symbol ]()
  //      case _      => face.companion.members
  //    }
  //
  //    val members = faceMembers ++ objectMembers
  //
  //    val methods = for {
  //      symbol <- members
  //      if ( symbol.isMethod )
  //      method = symbol.asMethod
  //      if ( hasAnnotation( method, typeOf[ Vuex.Mutation ] ) )
  //    } yield {
  //      method
  //    }
  //
  //    val mutations = members
  //      .find( _.name.decodedName.toString() == "mutations" )
  //      .getOrElse( fail( s"missing 'mutations' member in type ${face}" ) )
  //
  //    val names = methods.map( method => q"""
  //       ${method.name.decoded},
  //    """ )
  //
  //    val result = q"""
  //      js.Array[String] ( ..$names )
  //    """
  //
  //    info( s"${showCode( result )}" )
  //
  //    c.Expr[ js.Array[ String ] ]( result )
  //
  //  }

}
