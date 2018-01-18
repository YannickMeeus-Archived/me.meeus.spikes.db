package me.meeus.spikes.db.postgres

trait PostgresConnection {
  import scalikejdbc._

  Class.forName("org.postgresql.Driver")
  ConnectionPool.singleton("jdbc:postgresql://localhost:5432/postgres", "postgres", "")
  implicit val session: AutoSession.type = AutoSession
}
