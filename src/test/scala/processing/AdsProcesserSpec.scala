import org.scalatest._
import com.holdenkarau.spark.testing.DataFrameSuiteBase
import org.apache.spark.sql.types.{ArrayType, BooleanType, DoubleType, LongType, StringType, StructType}
import processing.AdsProcesser
import processing.models.RawDataframe

class AdsProcesserSpec extends FunSuite with DataFrameSuiteBase {

  test("create width and length column from a size column with an Array ") {

    val resourceRaw = getClass.getResource(s"/raw-data.json")
    val resourceExpected = getClass.getResource(s"/size-splitted-output.json")
    val rawSchema = new StructType()
      .add("appOrsite", StringType)
      .add("bidfloor", DoubleType)
      .add("city", StringType)
      .add("exchange", StringType)
      .add("impid", StringType)
      .add("interests", StringType)
      .add("label", BooleanType)
      .add("media", StringType)
      .add("network", StringType)
      .add("os", StringType)
      .add("publisher", StringType)
      .add("size", ArrayType(LongType))
      .add("timestamp", DoubleType)
      .add("type", StringType)
      .add("user", StringType)
      .add("id", StringType)

    val schemaSize = rawSchema
      .add("width", LongType)
      .add("length", LongType)
    import sqlContext.implicits._

    val dataset = spark.read
      .schema(rawSchema)
      .json(resourceRaw.getPath).as[RawDataframe]

    val splitteSizeDf = AdsProcesser.createEnrichedataset(dataset, spark)
      .select("id", "size", "length", "width").orderBy("id")

    val expectedDf = spark.read
      .schema(schemaSize)
      .json(resourceExpected.getPath)
      .select("id", "size", "length", "width").orderBy("id")

    assertDataFrameEquals(splitteSizeDf, expectedDf)
  }
}
