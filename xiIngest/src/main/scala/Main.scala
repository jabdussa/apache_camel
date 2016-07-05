import org.apache.camel.scala.dsl.builder.ScalaRouteBuilder

//import org.apache.camel.component.properties.PropertiesComponent
//
//import org.apache.camel.impl.DefaultPollingConsumerPollStrategy;


// we use a delay of 60 minutes (eg. once pr. hour we poll the FTP server
val delay = 3600000

// from the given FTP server we poll (= download) all the files
// from the public/reports folder as BINARY types and store this as files
// in a local directory. Camel will use the filenames from the FTPServer

// notice that the FTPConsumer properties must be prefixed with "consumer." in the URL
// the delay parameter is from the FileConsumer component so we should use consumer.delay as
// the URI parameter name. The FTP Component is an extension of the File Component.

case class Creds(val host:String, val port:String, val user:String, val pass:String)
case class Src(val path:String, val file: String)
case class Dst(val path:String, val file: String)

val creds = Creds("localhost", "22", "anwarabdus-samad", "")

val src = Src("/var/tmp/sftp_ingestion_test", "data.txt")

val dst = Dst("/var/tmp/sftp_ingestion_test", "data.txt.mmddyyhhmmss")


// for the server we want to delay 5 seconds between polling the server
// and move downloaded files to a done sub directory
val sftpDelay   = "5s"

val sftpMoveTo  = "done"

from(s"ftp://$creds.user:$creds.pass@$creds.host$src.path/$src.file?binary=true&consumer&delay=$sftpDelay").to(s"file://$dst.path/$dst.file")
