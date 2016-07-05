package com.carnival.xi

import org.apache.camel.{CamelContext => CC, Exchange => EX}
import org.apache.camel.scala.dsl.builder.ScalaRouteBuilder


/**
 * A Camel Router using the Scala DSL
 */

class Route(override val ctx: CC) 
  extends ScalaRouteBuilder(ctx) {

    // an example of a Processor method
   val p = (x: EX) => {
     x.getIn.setBody("block test")
   }
   
   // a route using Scala blocks
   "timer://foo?period=5s" ==> {
      process(p)
      to("log:block")
   }
   
}