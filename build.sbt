lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """sun-rays-radio""",
    version := "1.0",
    scalaVersion := "2.13.1",
    libraryDependencies ++= Seq(
      guice,
      "com.h2database" % "h2" % "1.4.199",
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
      "de.u-mass" % "lastfm-java" % "0.1.2"
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    )
  )
