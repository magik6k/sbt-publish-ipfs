sbtPlugin := true

version := "1.2.0"
name := "sbt-publish-ipfs"

organization := "eu.devtty"

lazy val publishDir = settingKey[String]("Publishing directory")
lazy val publishIpfs = taskKey[Unit]("Publish to IPFS")

publishDir := {
  import java.nio.file.Files
  Files.createTempDirectory("sbt-ipfs-").toString
}

publishTo := Some(Resolver.file("ipfs", file(publishDir.value)))

publishIpfs := {
  publish.value
  ("ipfs add -r " + publishDir.value) !
}
