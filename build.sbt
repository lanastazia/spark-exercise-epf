import sbt.Keys.{javaOptions, _}
val sparkVersion = "3.0.1"

inThisBuild(Seq(
  scalaVersion := "2.12.12",
  fork in Test := true,
  parallelExecution in Test := false,
  javaOptions in Test ++= Seq("-Xms512M", "-Xmx2048M", "-XX:+CMSClassUnloadingEnabled", "-Duser.timezone=UTC")
))

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-language:_",
  "-target:jvm-1.8",
  "-encoding", "UTF-8"
)

//Spark dependencies
val sparks = Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "org.apache.spark" %% "spark-hive" % sparkVersion,
  "com.holdenkarau" % "spark-testing-base_2.12" % "3.0.1_1.0.0" % "test"
)

libraryDependencies ++= Seq(
  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test") ++ sparks

parallelExecution in Test := false