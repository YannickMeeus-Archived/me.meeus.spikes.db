package me.meeus.spikes.db.commands

import scala.util.Try

trait IInitializeAnAuthorTable {
  def execute(): Try[Unit]
}

