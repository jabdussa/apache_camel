name := "apache_camel_sftp_example_v0"

version := "0.0"

scalaVersion := "2.11.8"

sbtVersion := "0.13.6"

sbtPlugin := true

test in assembly := {}

libraryDependencies ++= {
  Seq(
    "org.apache.camel" 	% "camel-scala" % "2.17.2",
    "org.apache.camel" 	% "camel-core"  % "2.17.2",
    "org.apache.camel" 	% "camel-ftp"   % "2.17.2",
    "org.slf4j"		  	  % "slf4j-api"   % "1.7.21",
    "org.slf4j"		  	  % "slf4j-log4j12" % "1.7.21",
    "log4j" 				    % "log4j"       % "1.2.17"
  )
}
