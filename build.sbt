import sbt.Path

val sparkVersion = "2.3.1"

val hadoopVersion = "2.8.1"

name := "zero-scala"

version := "0.1"

scalaVersion := "2.11.8"

lazy val zerospark = (project in file("zero-spark"))
  .settings(basicSettings)
  .settings(libraryDependencies ++= Seq(
    "org.apache.spark" %% "spark-core" % sparkVersion,
    "org.apache.spark" %% "spark-sql" % sparkVersion,
    "org.apache.spark" %% "spark-streaming" % sparkVersion,
    "org.apache.spark" %% "spark-streaming-kafka-0-10" % sparkVersion,
    "org.apache.hadoop" % "hadoop-client" % hadoopVersion
  ))

lazy val root = (project in file("."))
  .dependsOn(zerospark)

lazy val basicSettings: Seq[Def.Setting[_]] = Defaults.coreDefaultSettings ++ Seq(
  resolvers ++= Seq(
    "Local Maven" at Path.userHome.asURL + ".m2/repository",
    "ximalaya-central" at "http://artifactory.ximalaya.com/artifactory/repo",
    "ximalaya-snapshots" at "http://artifactory.ximalaya.com/artifactory/repo"
  ),
  scalaVersion := "2.11.8"
)

