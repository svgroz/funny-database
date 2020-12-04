import sbt._

object Dependencies {
  val scalatest = "org.scalatest" %% "scalatest" % "3.2.2" % "test"
  val scalatest_flatspec = "org.scalatest" %% "scalatest-flatspec" % "3.2.2" % "test"

  val commonDependencies = Seq(scalatest, scalatest_flatspec)
}

