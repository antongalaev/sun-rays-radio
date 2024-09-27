lazy val root = (project in file("."))
  .enablePlugins(PlayScala, UniversalPlugin)
  .settings(
    name := """sun-rays-radio""",
    version := "2.0",
    maintainer := "sunraysradio@gmail.com",
    scalaVersion := "3.5.1",
    libraryDependencies ++= Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test,
      "de.u-mass" % "lastfm-java" % "0.1.2"
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-Xfatal-warnings"
    )
  )