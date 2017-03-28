import sbt._
import Keys._

object IpfsPublish extends AutoPlugin {
  object autoImport {
    lazy val publishDir = settingKey[String]("Publishing directory")
    lazy val publishIpfs = taskKey[Unit]("Publish to IPFS")
  }

  import autoImport._

  override lazy val buildSettings = super.buildSettings ++ Seq(
    publishDir := {
      import java.nio.file.Files
      Files.createTempDirectory("sbt-ipfs-").toString
    },

    publishTo := Some(Resolver.file("ipfs", file(publishDir.value))),

    publishIpfs := {
      (publish in LocalRootProject).value
      ("ipfs add -r " + publishDir.value) !
    }
  )
}
