package me.meeus.spikes.db

import me.meeus.spikes.db.postgres.InitializeAuthorTable

import scala.io.StdIn
import scala.util.Failure
import scala.util.Success
import scala.util.Try

object EntryPoint extends App {
  println("Running")
  println("Setting up Connection Pool")

  println("Creating an author table...")

  val result: Try[Unit] = InitializeAuthorTable.execute()
  result match {
    case Success(_) => println("Created Authors Table or already exists")
    case Failure(e) => println(s"Failed to create Authors Table with exception: $e")
  }
  println("Press any key to exit...")
  StdIn.readLine()
}



