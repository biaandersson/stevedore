ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.0"

val commonSettings = Seq(
  scalaVersion := "3.2.0",
  scalacOptions -= "-Xfatal-warnings",
  libraryDependencies ++= Seq(
    "org.typelevel" %% "cats-effect" % "3.3.14",
    "org.typelevel" %% "cats-mtl" % "1.3.0",
    "org.typelevel" %% "munit-cats-effect-3" % "1.0.7",
  ),
)

val shared = project.settings(commonSettings)
val client = project.settings(commonSettings).dependsOn(shared)
val server = project.settings(commonSettings).dependsOn(shared)

lazy val root = (project in file("."))
  .settings(
    name := "stevedore",
    idePackagePrefix := Some("com.tba"),
    publish := {},
  )
  .aggregate(server, client, shared)
