package me.meeus.spikes.db.postgres.models

case class DBAuthor(
                     id: Option[Int],
                     firstName: String,
                     lastName: String
                   )
