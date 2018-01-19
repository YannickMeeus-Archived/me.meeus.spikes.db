package me.meeus.spikes.db.models

import io.jvm.uuid._

case class Author(
                   id: UUID,
                   firstName: String,
                   lastName: String
                 )
