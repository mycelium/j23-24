name := "funsets"

scalaVersion := "2.12.7"

mainClass in Compile := Some("tasks\\scala\\1\\Main.scala")

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-optimise",
  "-Yinline-warnings"
)

fork := true

javaOptions += "-Xmx2G"

parallelExecution in Test := false
