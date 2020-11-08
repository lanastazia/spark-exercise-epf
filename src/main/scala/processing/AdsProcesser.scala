package processing

import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}
import org.apache.spark.sql.types.{StringType, StructType}

object AdsProcesser {

  def run(spark: SparkSession): Unit = {

    val rawSchema = new StructType()
      .add("os", StringType)
      .add("city", StringType)

    import spark.implicits._

    spark.stop()

  }

  def createEnrichedataset[T](dataset: Dataset[T], spark: SparkSession): DataFrame = {
    ???
  }

}
