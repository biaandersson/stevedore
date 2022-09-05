package steve

import cats.Id
import munit.CatsEffectSuite

class ExecutorTests extends CatsEffectSuite {
  val exec = Executor.instance[Either[Throwable, *]]

  test("Build and run empty image") {

    assertEquals(
      exec.build(Build.empty).flatMap(exec.run).map(_.getAll),
      Right(Map.empty),
    )
  }
}
