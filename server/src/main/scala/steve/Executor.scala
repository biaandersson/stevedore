import steve.Build

import steve.Executor
import steve.Hash

trait Executor[F[_]] {
  def build(build: Build): F[Hash]

  def run(hash: Hash): F[Unit]
}

object Executor {
  def apply[F[_]](using F: Executor[F]): Executor[F] = F
}
