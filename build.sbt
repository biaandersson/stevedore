ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.0"

ThisBuild / versionScheme := Some("early-semver")

ThisBuild / githubWorkflowPublishTargetBranches := Seq()

val commonSettings = Seq(
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
    publish / skip := true,
  )
  .aggregate(server, client, shared)
