package scalajs.vue.util

import com.carrotgarden.sjs.junit.ScalaJS_Suite

import org.junit.Test
import org.junit.Ignore
import org.junit.Assert._
import org.junit.runner.RunWith
import org.junit.runners.Suite

class Namer01 {

  import Namer._

  @Test
  def propertyTest = {
    assertEquals( convertCamelKebab( "Status" ), "status" )
    assertEquals( convertCamelKebab( "SomeName" ), "some-name" )
  }

}

@RunWith( classOf[ ScalaJS_Suite ] )
@Suite.SuiteClasses( Array(
  classOf[ Namer01 ]
) )
class NamerTest
