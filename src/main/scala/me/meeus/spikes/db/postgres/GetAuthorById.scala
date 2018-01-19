package me.meeus.spikes.db.postgres

import me.meeus.spikes.db.models.Author
import me.meeus.spikes.db.queries.IGetAnAuthorById
import scalikejdbc._
import io.jvm.uuid._
import me.meeus.spikes.db.postgres.models.DBAuthor

class GetAuthorById(implicit session: DBSession = AutoSession) extends IGetAnAuthorById {
  override def execute(id: UUID): Option[Author] = {
    val statement =
      sql"""
           |SELECT
           | id
           | , first_name
           | , last_name
           | FROM
           |   authors
           | WHERE
           |   id = ${id.toString}
         """.stripMargin

    statement
      .map(rs => DBAuthor(rs)) // Apply the result set to a DBAuthor
      .first() // Grab the first result if it exists
      .apply() // Run the query
      .map(_.toAuthor) // Map the DBAuthor back to an Author
  }
}
