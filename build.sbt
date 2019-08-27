name := "MyFirstScalaSpark"
version := "0.1.0-SNAPSHOT"
scalaVersion := "2.12.8"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.2"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.2"

publishTo := Some("Sonatype Snapshots Nexus" at "http://localhost:8081/repository/project/")