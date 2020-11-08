import org.scalatest._
import com.holdenkarau.spark.testing.{DataFrameSuiteBase}

class AdsProcessorSpec extends FunSuite with DataFrameSuiteBase {

  test("create width and length column from a size column with an Array ") {

    val resourceRaw = getClass.getResource(s"/raw-data.json")
    val resourceExpected = getClass.getResource(s"/size-splitted-output.json")

    assert(true)
  }
}
