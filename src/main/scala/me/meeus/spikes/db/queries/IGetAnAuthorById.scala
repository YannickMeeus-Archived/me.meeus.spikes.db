package me.meeus.spikes.db.queries

import io.jvm.uuid._
import me.meeus.spikes.db.models.Author

trait IGetAnAuthorById {
  def execute(id: UUID): Option[Author]
}
