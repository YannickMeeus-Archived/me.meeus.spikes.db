package me.meeus.spikes.db.anorm.postgres.models

case class DBAuthor(
                     id: Option[Int],
                     firstName: String,
                     lastName: String
                   )
