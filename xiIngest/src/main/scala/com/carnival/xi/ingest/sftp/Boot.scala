package com.carnival.xi.ingest.sftp

import org.apache.camel.main.Main
import org.apache.camel.scala.dsl.builder.RouteBuilderSupport

/**
 * Main/Boot class for SFTP Camel Route
 */
object Boot

  extends RouteBuilderSupport {

  def main(args: Array[String]) {
    val main = new Main()

    // camel context
    val context = main.getOrCreateCamelContext()

    // add our route
    main.addRouteBuilder(new Boot(context))

    // start the application
    main.run()
  }

}
