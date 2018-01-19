package me.meeus.spikes.db.commands

import me.meeus.spikes.db.models.Author

import scala.util.Try

trait ISaveAnAuthor {
  def execute(author: Author): Try[Unit]
}
