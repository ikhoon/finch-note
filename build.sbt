name := "finch-note"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
  "com.github.finagle" %% "finch-core" % "0.11.1",
  "com.github.finagle" %% "finch-circe" % "0.11.1",
  "io.circe" %% "circe-generic" % "0.6.1"
)
