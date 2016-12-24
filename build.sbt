name := "finch-note"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
  "com.github.finagle" %% "finch-core" % "0.12.0-SNAPSHOT",
  "com.github.finagle" %% "finch-circe" % "0.12.0-SNAPSHOT",
  "io.circe" %% "circe-generic" % "0.7.0-M1"
)
