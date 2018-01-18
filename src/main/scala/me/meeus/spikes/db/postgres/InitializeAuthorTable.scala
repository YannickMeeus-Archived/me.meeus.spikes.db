package me.meeus.spikes.db.postgres

import me.meeus.spikes.db.commands.IInitializeAnAuthorTable

import scala.util.Try

object InitializeAuthorTable extends IInitializeAnAuthorTable with PostgresConnection {

  import scalikejdbc._

  private val createAuthorTable =
    sql"""
         |create table if not exists authors (
         |  id serial not null primary key,
         |  first_name varchar(64) not null,
         |  last_name varchar(64) not null
         |)
    """.stripMargin


  override def execute(): Try[Unit] = {
    Try(createAuthorTable.execute().apply())
  }
}