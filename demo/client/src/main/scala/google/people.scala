package google

import scala.concurrent.{ Promise, Future }
import scala.scalajs.js
import js.annotation._
import scala.util.Try
import scala.scalajs.js.Any.jsArrayOps
import scala.scalajs.js.UndefOr.undefOr2ops

trait people {

}

object people {

  case class IncludeField( field : String )

  object IncludeField {
    val addresses = IncludeField( "person.addresses" )
    val age_range = IncludeField( "person.age_range" )
    val biographies = IncludeField( "person.biographies" )
    val birthdays = IncludeField( "person.birthdays" )
    val bragging_rights = IncludeField( "person.bragging_rights" )
    val cover_photos = IncludeField( "person.cover_photos" )
    val email_addresses = IncludeField( "person.email_addresses" )
    val events = IncludeField( "person.events" )
    val genders = IncludeField( "person.genders" )
    val im_clients = IncludeField( "person.im_clients" )
    val interests = IncludeField( "person.interests" )
    val locales = IncludeField( "person.locales" )
    val memberships = IncludeField( "person.memberships" )
    val metadata = IncludeField( "person.metadata" )
    val names = IncludeField( "person.names" )
    val nicknames = IncludeField( "person.nicknames" )
    val occupations = IncludeField( "person.occupations" )
    val organizations = IncludeField( "person.organizations" )
    val phone_numbers = IncludeField( "person.phone_numbers" )
    val photos = IncludeField( "person.photos" )
    val relations = IncludeField( "person.relations" )
    val relationship_interests = IncludeField( "person.relationship_interests" )
    val relationship_statuses = IncludeField( "person.relationship_statuses" )
    val residences = IncludeField( "person.residences" )
    val skills = IncludeField( "person.skills" )
    val taglines = IncludeField( "person.taglines" )
    val urls = IncludeField( "person.urls" )
  }

  //https://developers.google.com/people/api/rest/v1/people#Name
  @js.native
  trait Name extends js.Object {
    var displayName : js.UndefOr[ String ] = js.native
    var displayNameLastFirst : js.UndefOr[ String ] = js.native
    var familyName : js.UndefOr[ String ] = js.native
    var givenName : js.UndefOr[ String ] = js.native
    var middleName : js.UndefOr[ String ] = js.native
    var honorificPrefix : js.UndefOr[ String ] = js.native
    var honorificSuffix : js.UndefOr[ String ] = js.native
    var phoneticFullName : js.UndefOr[ String ] = js.native
    var phoneticFamilyName : js.UndefOr[ String ] = js.native
    var phoneticGivenName : js.UndefOr[ String ] = js.native
    var phoneticMiddleName : js.UndefOr[ String ] = js.native
    var phoneticHonorificPrefix : js.UndefOr[ String ] = js.native
    var phoneticHonorificSuffix : js.UndefOr[ String ] = js.native
  }

  //https://developers.google.com/people/api/rest/v1/people#Photo
  @js.native
  trait Photo extends js.Object {
    var url : js.UndefOr[ String ] = js.native
  }

  // https://developers.google.com/people/api/rest/v1/people#Address
  @js.native
  trait Address extends js.Object {
    var formattedValue : js.UndefOr[ String ] = js.native
    var `type` : js.UndefOr[ String ] = js.native
    var formattedType : js.UndefOr[ String ] = js.native
    var poBox : js.UndefOr[ String ] = js.native
    var streetAddress : js.UndefOr[ String ] = js.native
    var extendedAddress : js.UndefOr[ String ] = js.native
    var city : js.UndefOr[ String ] = js.native
    var region : js.UndefOr[ String ] = js.native
    var postalCode : js.UndefOr[ String ] = js.native
    var country : js.UndefOr[ String ] = js.native
    var countryCode : js.UndefOr[ String ] = js.native
  }

  // https://developers.google.com/people/api/rest/v1/people#EmailAddress
  @js.native
  trait EmailAddress extends js.Object {
    var value : js.UndefOr[ String ] = js.native
    var `type` : js.UndefOr[ String ] = js.native
    var formattedType : js.UndefOr[ String ] = js.native
    var displayName : js.UndefOr[ String ] = js.native
  }

  // https://developers.google.com/people/api/rest/v1/people#PhoneNumber
  @js.native
  trait PhoneNumber extends js.Object {
    var value : js.UndefOr[ String ] = js.native
    var canonicalForm : js.UndefOr[ String ] = js.native
    var `type` : js.UndefOr[ String ] = js.native
    var formattedType : js.UndefOr[ String ] = js.native
  }

  //https://developers.google.com/people/api/rest/v1/people#Person
  @js.native
  trait Person extends js.Object {
    var resourceName : js.UndefOr[ String ] = js.native
    var etag : js.UndefOr[ String ] = js.native
    //var metadata: js.UndefOr[PersonMetadata] = js.native
    //var locales: js.UndefOr[js.Array[Locale]] = js.native
    var names : js.UndefOr[ js.Array[ Name ] ] = js.native
    //var nicknames: js.UndefOr[js.Array[Nickname]] = js.native
    //var coverPhotos: js.UndefOr[js.Array[CoverPhoto]] = js.native
    var photos : js.UndefOr[ js.Array[ Photo ] ] = js.native
    //var genders: js.UndefOr[js.Array[Gender]] = js.native
    //var ageRange: js.UndefOr[AgeRange] = js.native
    //var birthdays: js.UndefOr[js.Array[Birthday]] = js.native
    //var events: js.UndefOr[js.Array[Event]] = js.native
    var addresses : js.UndefOr[ js.Array[ Address ] ] = js.native
    //var residences: js.UndefOr[js.Array[Residence]] = js.native
    var emailAddresses : js.UndefOr[ js.Array[ EmailAddress ] ] = js.native
    var phoneNumbers : js.UndefOr[ js.Array[ PhoneNumber ] ] = js.native
    //var imClients: js.UndefOr[js.Array[ImClient]] = js.native
    //var taglines: js.UndefOr[js.Array[Tagline]] = js.native
    //var biographies: js.UndefOr[js.Array[Biography]] = js.native
    //var urls: js.UndefOr[js.Array[Url]] = js.native
    //var organizations: js.UndefOr[js.Array[Organization]] = js.native
    //var occupations: js.UndefOr[js.Array[Occupation]] = js.native
    //var interests: js.UndefOr[js.Array[Interest]] = js.native
    //var skills: js.UndefOr[js.Array[Skill]] = js.native
    //var braggingRights: js.UndefOr[js.Array[BraggingRights]] = js.native
    //var relations: js.UndefOr[js.Array[Relation]] = js.native
    //var relationshipInterests: js.UndefOr[js.Array[RelationshipInterest]] = js.native
    //var relationshipStatuses: js.UndefOr[js.Array[RelationshipStatus]] = js.native
    //var memberships: js.UndefOr[js.Array[Membership]] = js.native
  }

  @js.native
  trait Connections extends js.Object {
    var connections : js.UndefOr[ js.Array[ Person ] ] = js.native
    var nextPageToken : js.UndefOr[ String ] = js.native
    var nextSyncToken : js.UndefOr[ String ] = js.native
  }

  def get[ T ]( x : js.UndefOr[ js.Array[ T ] ] ) : List[ T ] = x.toOption.map( _.toList ).getOrElse( Nil )

  def connections( pageSize : Int, includeFields : List[ IncludeField ] = List( IncludeField.names, IncludeField.addresses, IncludeField.photos, IncludeField.phone_numbers, IncludeField.email_addresses ) ) : Future[ Connections ] = {
    val p = Promise[ Connections ]
    //https://developers.google.com/people/api/rest/v1/people.connections/list

    //curl 'https://content-people.googleapis.com/v1/people/me/connections?pageSize=500&requestMask.includeField=person.names%2Cperson.photos%2Cperson.email_addresses%2Cperson.phone_numbers' -H 'Authorization: Bearer ya29.CjCKAzG1ViW_c-NcKh7AAl4mheXRbO6UPJ5e_zgseQlqCqaSuWoas7vncE3U4C9RN94' -H 'X-Goog-Encode-Response-If-Executable: base64' -H 'X-Origin: https://local.conversant.im' -H 'X-ClientDetails: appVersion=5.0%20(X11%3B%20Linux%20x86_64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F53.0.2785.143%20Safari%2F537.36&platform=Linux%20x86_64&userAgent=Mozilla%2F5.0%20(X11%3B%20Linux%20x86_64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F53.0.2785.143%20Safari%2F537.36' -H 'User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36' -H 'Referer: https://content-people.googleapis.com/static/proxy.html?jsh=m%3B%2F_%2Fscs%2Fapps-static%2F_%2Fjs%2Fk%3Doz.gapi.en_GB.j5SEgpkFjY8.O%2Fm%3D__features__%2Fam%3DAQ%2Frt%3Dj%2Fd%3D1%2Frs%3DAGLTcCPlzTAxAErhh97p9zJGiTmUt2wdEA' -H 'X-JavaScript-User-Agent: google-api-javascript-client/1.1.0-beta' -H 'X-Referer: https://local.conversant.im' --compressed
    val req = gapi.client.request( RequestParams(
      root = "https://people.googleapis.com",
      path = s"v1/people/me/connections?pageSize=${pageSize}&requestMask.includeField=${js.URIUtils.encodeURIComponent( includeFields.map( _.field ).mkString( "," ) )}"
    ) ).asInstanceOf[ gapi.client.HttpRequest[ Connections ] ]
    req.execute( { ( c : people.Connections, a : Any ) =>
      p.complete( Try( c ) )
    } )
    p.future
  }

}
