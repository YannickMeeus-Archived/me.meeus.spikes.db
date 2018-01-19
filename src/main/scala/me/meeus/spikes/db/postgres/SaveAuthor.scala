package me.meeus.spikes.db.postgres

import me.meeus.spikes.db.commands.ISaveAnAuthor
import me.meeus.spikes.db.models.Author
import me.meeus.spikes.db.postgres.models.DBAuthor

import scala.util.Try
import scalikejdbc._

class SaveAuthor(implicit session: DBSession = AutoSession) extends ISaveAnAuthor {
  override def execute(author: Author): Try[Unit] = {
    val toSave = DBAuthor.fromAuthor(author)
    val statement =
      sql"""
           | INSERT INTO
           |   authors
           |   (
           |     id
           |     , first_name
           |     , last_name
           |   )
           | VALUES
           | (
           |    ${toSave.id}
           |    , ${toSave.firstName}
           |    , ${toSave.lastName}
           | )
      """.stripMargin
    Try {
      statement
        .execute()
        .apply()
    }
  }
}
