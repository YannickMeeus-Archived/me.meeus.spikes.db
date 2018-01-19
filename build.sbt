lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "me.meeus",
      scalaVersion := "2.12.4",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "me.meeus.spikes.db.access",
    libraryDependencies ++= Seq(
      "org.scalikejdbc" %% "scalikejdbc" % "3.1.0",
      "postgresql" % "postgresql" % "9.1-901.jdbc4",
      "io.jvm.uuid" %% "scala-uuid" % "0.2.3"
    )
  )
