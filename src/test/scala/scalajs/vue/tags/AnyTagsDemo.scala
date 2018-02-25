package scalajs.vue.tags

import scalajs.vue.tags.AnyTags._

import scalatags.JsDom
import scalatags.JsDom.all._
import scalajs.vue.tags.Name
import scalajs.vue.tags.ListName

object VueScalaTagsDemo extends App {

  val item = Name[ Int ]( "item" );
  val itemList = ListName[ Int ]( "item_list" );

  val test = html(
    body(
      router.link( "/tester" )( "hello" ),
      div( v( "dir" ) := "isOn" ),
      div( v.if_ := "isOn" ),
      div( v.for_ := "item in item_list" ),
      //      div( v.forEach( item, itemList ) ),
      div( v.bind( "text" ) := "..." ),
      bs.progress( "" ),
      bs.progress.bar( "hello" ),
      bs.form( bs.show ),
      div()
    )
  )

  //  println( test.render.textContent )

}
