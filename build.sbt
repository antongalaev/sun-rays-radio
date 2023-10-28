lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """sun-rays-radio""",
    version := "1.0",
    scalaVersion := "3.3.1",
    libraryDependencies ++= Seq(
      guice,
      "com.h2database" % "h2" % "1.4.199",
      "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.0" % Test,
      "de.u-mass" % "lastfm-java" % "0.1.2"
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-Xfatal-warnings"
    )
  )

// Config for assembly
mainClass in assembly := Some("play.core.server.ProdServerStart")
fullClasspath in assembly += Attributed.blank(PlayKeys.playPackageAssets.value)

// Merge strategy for assembling conflicts
assemblyMergeStrategy in assembly := {
  case PathList("reference.conf") => MergeStrategy.concat
  case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
  case _ => MergeStrategy.first
}

// test comment