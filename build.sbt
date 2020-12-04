import Dependencies._

name := "funny-database"

version := "0.1"

scalaVersion := "2.13.4"

lazy val global = project
  .in(file("."))
  .aggregate(
    datatypes
  )


val settings = Seq()

lazy val datatypes = (project in file ("datatypes"))
  .settings(
    name:= "datatypes",
    libraryDependencies ++= commonDependencies
  )
