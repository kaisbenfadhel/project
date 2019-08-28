name := "MyFirstScalaSpark"
version := "0.1.0"
scalaVersion := "2.12.8"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.2"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.2"



sbtPlugin := true

publishMavenStyle := true
//publishArtifact in Test := false
//pomIncludeRepository := { _ => false }
resolvers += "Sonatype Nexus Repository Manager" at "http://localhost:8081/#admin/repository/repositories:maven-public"
//credentials += Credentials(Path.userHome / ".ivy2" / "credentials")
//credentials += Credentials("Sonatype Nexus Repository Manager", "http://localhost:8081/", "admin", "admin1234")
credentials += Credentials("Sonatype Nexus",  "nexus.scala-tools.org", "admin", "admin1234")
publishConfiguration := publishConfiguration.value.withOverwrite(true)
publishLocalConfiguration := publishLocalConfiguration.value.withOverwrite(true)

//publishTo := Some("Sonatype Nexus Repository Manager" at "http://localhost:8081/repository/snapshots/")
//publishTo := Some("Sonatype Snapshots Nexus" at "http://localhost:8081/repository/snapshots/")

isSnapshot := true
publishTo := {
  val nexus = "http://localhost:8081/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "#admin/repository/repositories:maven-snapshots")
  else
    Some("releases"  at nexus + "#admin/repository/repositories:maven-releases")
}
// This will use Nexus as a resolver.
//resolvers += "Sonatype Nexus Repository Manager" at "http://localhost:8081/repository/snapshots/"
// This will prevent access to Maven Central.
//externalResolvers := Resolver.combineDefaultResolvers(resolvers.value.toVector, false)
//externalResolvers := Resolver.withDefaultResolvers(resolvers.value, mavenCentral = false)
//ThisBuild / publishTo := {
//val nexus = "http://localhost:8081/"
//if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
// else Some("releases" at nexus + "service/local/staging/deploy/maven2")
//}
//ThisBuild / publishMavenStyle := true
//useGpg := true
