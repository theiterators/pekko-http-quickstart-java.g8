ThisBuild / Compile / run / fork := true
ThisBuild / Compile / run / outputStrategy := Some(StdoutOutput)

resolvers += "Apache Snapshots" at "https://repository.apache.org/content/repositories/snapshots/"

lazy val root = (project in file(".")).settings(
  inThisBuild(List(organization := "$organization$", scalaVersion := "2.13.10", name := "$name$")),
  name := "$name$",
  libraryDependencies ++= {
    val pekkoV          = "$pekko_version$"
    val pekkoHttpV      = "$pekko_http_version$"
    val logbackV        = "1.4.5"
    val junitV          = "4.13.2"
    val junitInterfaceV = "0.11"
    Seq(
      "org.apache.pekko" %% "pekko-http"                % pekkoHttpV,
      "org.apache.pekko" %% "pekko-actor-typed"         % pekkoV,
      "org.apache.pekko" %% "pekko-stream"              % pekkoV,
      "org.apache.pekko" %% "pekko-http-jackson"        % pekkoHttpV,
      "ch.qos.logback"    % "logback-classic"           % logbackV,
      "org.apache.pekko" %% "pekko-testkit"             % pekkoV          % Test,
      "org.apache.pekko" %% "pekko-http-testkit"        % pekkoHttpV      % Test,
      "org.apache.pekko" %% "pekko-actor-testkit-typed" % pekkoV          % Test,
      "junit"             % "junit"                     % junitV          % Test,
      "com.novocode"      % "junit-interface"           % junitInterfaceV % Test
    )
  },
  testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")
)
