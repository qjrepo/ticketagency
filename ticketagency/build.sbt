name := """play-scala-starter-example"""

version := "1.0-SNAPSHOT"

//version := "1.0.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

resolvers += Resolver.sonatypeRepo("snapshots")
//lazy val akkaVersion = "2.5.25"
scalaVersion := "2.12.4" //2.12.0

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.0" % Test // 4.0.2
libraryDependencies += "com.h2database" % "h2" % "1.4.199"

libraryDependencies ++= Seq(
  specs2                                                          % Test,
  "com.typesafe.akka"       %  "akka-testkit_2.12"    % "2.5.25"   % Test,
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  //  "com.typesafe.akka" %% "akka-actor-testkit-typed" % "2.5.6"  % Test,
  "org.scalatest" %% "scalatest" % "3.0.4" % Test,
  "com.typesafe.akka" %% "akka-slf4j" % "2.5.25"
)

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-Xfatal-warnings"
)

// only for Play 2.7.x (Scala 2.12)
libraryDependencies ++= Seq(
  "org.reactivemongo" %% "play2-reactivemongo" % "0.19.0-play27"
)



