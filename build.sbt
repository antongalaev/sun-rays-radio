lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """sun-rays-radio""",
    version := "1.0",
    scalaVersion := "3.3.1",
    libraryDependencies ++= Seq(
      guice,
      "com.h2database" % "h2" % "2.2.224",
      "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.0" % Test,
      "de.u-mass" % "lastfm-java" % "0.1.2"
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-Xfatal-warnings"
    )
  )

// Config for assembly
assembly / mainClass := Some("play.core.server.ProdServerStart")
assembly / fullClasspath += Attributed.blank(PlayKeys.playPackageAssets.value)

// Merge strategy for assembling conflicts
assembly / assemblyMergeStrategy := {
  case PathList("reference.conf") => MergeStrategy.concat
  case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
  case _ => MergeStrategy.first
}
