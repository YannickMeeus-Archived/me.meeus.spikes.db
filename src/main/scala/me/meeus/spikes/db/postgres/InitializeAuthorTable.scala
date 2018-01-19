package me.meeus.spikes.db.postgres

import me.meeus.spikes.db.commands.IInitializeAnAuthorTable
import scalikejdbc._
import scala.util.Try

class InitializeAuthorTable(implicit session: DBSession = AutoSession) extends IInitializeAnAuthorTable {
  private val createAuthorTable =
    sql"""
         |CREATE TABLE IF NOT EXISTS authors (
         |  id VARCHAR(36) NOT NULL PRIMARY KEY,
         |  first_name VARCHAR(64) NOT NULL,
         |  last_name VARCHAR(64) NOT NULL
         |)
    """.stripMargin

  override def execute(): Try[Unit] = {
    Try {
      createAuthorTable
        .execute()
        .apply()
    }
  }
}