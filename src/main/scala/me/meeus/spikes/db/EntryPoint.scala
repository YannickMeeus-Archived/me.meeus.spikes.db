package me.meeus.spikes.db

import me.meeus.spikes.db.models.Author
import me.meeus.spikes.db.postgres.InitializeAuthorTable
import io.jvm.uuid._
import me.meeus.spikes.db.postgres.GetAuthorById
import me.meeus.spikes.db.postgres.SaveAuthor
import scalikejdbc.AutoSession
import scalikejdbc.ConnectionPool

import scala.io.StdIn
import scala.util.Failure
import scala.util.Success
import scala.util.Try

object EntryPoint extends App {
  println("Running")
  println("Setting up Connection Pool")

  Class.forName("org.postgresql.Driver")
  ConnectionPool.singleton("jdbc:postgresql://localhost:5432/postgres", "postgres", "")
  implicit val session: AutoSession.type = AutoSession

  println("Creating an author table...")
  val createdTableResult: Try[Unit] = new InitializeAuthorTable().execute()
  createdTableResult match {
    case Success(_) => println("Created Authors Table or already exists")
    case Failure(e) => println(s"Failed to create Authors Table with exception: $e")
  }

  println("Insert a new author")
  val authorToSave = Author(UUID.random, "yannick", "meeus")
  val savedAuthor = new SaveAuthor().execute(authorToSave)

  savedAuthor match {
    case Success(_) => println("Saved author")
    case Failure(e) => println(s"Failed to save author with exception: $e")
  }

  val retrievedAuthor = new GetAuthorById().execute(authorToSave.id)
  retrievedAuthor match {
    case Some(s) => println(s"Author found with first name: ${s.firstName} and last name: ${s.lastName}")
    case None => println(s"No author found with id: ${authorToSave.id.toString}")
  }

  println("Press any key to exit...")
  StdIn.readLine()
}



