package me.meeus.spikes.db.postgres.models

import me.meeus.spikes.db.models.Author
import io.jvm.uuid._
import scalikejdbc._

case class DBAuthor(
                     id: String,
                     firstName: String,
                     lastName: String
                   ) {
  def toAuthor: Author = {
    Author(UUID(this.id), this.firstName, this.lastName)
  }
}

object DBAuthor extends SQLSyntaxSupport[DBAuthor] {
  override val tableName = "authors"

  def apply(result: WrappedResultSet): DBAuthor = new DBAuthor(result.string("id"), result.string("first_name"), result.string("last_name"))

  def fromAuthor(author: Author): DBAuthor = DBAuthor(author.id.toString, author.firstName, author.lastName)
}
