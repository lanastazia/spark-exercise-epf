package processing

import java.util.TimeZone

import com.typesafe.scalalogging.StrictLogging
import org.apache.spark.sql.SparkSession

object Main extends StrictLogging {

  def main(args: Array[String]): Unit = {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"))

    val spark = SparkSession.builder
      .master("local[*]")
      .appName("etl-epf")
      .config("spark.driver.memory", "6g")
      .getOrCreate()

    logger.info("Run Spark application")

   AdsProcesser.run(spark)

  }

}
