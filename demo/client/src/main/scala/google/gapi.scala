package google

import scala.scalajs.js
import js.annotation._
import scala.scalajs.js.Any.fromBoolean
import scala.scalajs.js.Any.fromString
import scala.scalajs.js.UndefOr.undefOr2ops

@js.native
trait GoogleApiOAuth2TokenObject extends js.Object {
  var access_token : String = js.native
  var error : js.UndefOr[ String ] = js.native
  var expires_in : String = js.native
  var state : String = js.native
}

@js.native
trait AuthParams extends js.Object {
  var client_id : String = js.native
  var scope : js.Array[ String ] = js.native
  var immediate : js.UndefOr[ Boolean ] = js.native
}

object AuthParams {
  def apply(
    client_id : js.UndefOr[ String ]             = js.undefined,
    scope :     js.UndefOr[ js.Array[ String ] ] = js.undefined,
    immediate : js.UndefOr[ Boolean ]            = js.undefined
  ) : AuthParams = {
    val result = js.Dynamic.literal()
    client_id.foreach( result.client_id = _ )
    scope.foreach( result.scope = _ )
    immediate.foreach( result.immediate = _ )
    result.asInstanceOf[ AuthParams ]
  }
}

@js.native
trait RequestParams extends js.Object {
  var root : String = js.native
  var path : String = js.native
}

object RequestParams {
  def apply(
    root : String,
    path : String
  ) : RequestParams = {
    val result = js.Dynamic.literal()
    result.root = root
    result.path = path
    result.asInstanceOf[ RequestParams ]
  }
}

trait gapi {

}

@JSGlobal
@js.native
object gapi extends js.Object {

  import scala.scalajs.js.Promise

  @js.native
  object auth extends js.Object {
    def authorize( params : AuthParams, callback : js.Function1[ GoogleApiOAuth2TokenObject, Any ] ) : Unit = js.native
    def init( callback : js.Function0[ Any ] ) : Unit = js.native
    def getToken() : GoogleApiOAuth2TokenObject = js.native
    def setToken( token : GoogleApiOAuth2TokenObject ) : Unit = js.native
    def signIn( params : js.Any ) : Unit = js.native
    def signOut() : Unit = js.native
  }

  @js.native
  object auth2 extends js.Object {
    def getAuthInstance : Unit = js.native
  }

  @js.native
  object client extends js.Object {

    @js.native
    class HttpRequest[ T ] extends js.Object {
      def execute( callback : js.Function2[ T, js.Any, Any ] ) : Unit = js.native
      def then( success : js.Function1[ js.Any, Unit ], failure : js.Function1[ js.Any, Unit ] ) : Unit = js.native
    }

    @js.native
    class HttpBatch extends js.Object {
      def add( httpRequest : HttpRequest[ js.Any ], opt_params : js.Any = ??? ) : Unit = js.native
      def execute( callback : js.Function2[ js.Any, String, Any ] ) : Unit = js.native
    }

    @js.native
    class RpcRequest extends js.Object {
      def callback( callback : js.Function2[ js.Any, String, Unit ] ) : Unit = js.native
    }

    def load( name : String, version : String ) : Promise[ Unit ] = js.native
    def load( name : String, version : String, callback : js.Function0[ Any ], url : String = ??? ) : Unit = js.native
    def request( args : js.Any ) : HttpRequest[ js.Any ] = js.native
    def rpcRequest( method : String, version : String = ???, rpcParams : js.Any = ??? ) : RpcRequest = js.native
    def setApiKey( apiKey : String ) : Unit = js.native
  }

}
