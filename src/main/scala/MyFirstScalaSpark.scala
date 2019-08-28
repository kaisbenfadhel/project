package com.example
import org.apache.spark.sql.SparkSession
object MyFirstScalaSpark {
  def main(args: Array[String]) {
    val spark = SparkSession.builder
      .appName("MyFirstScalaSpark")
      .getOrCreate()
    val filePath = args(0)
    val data = spark.read
      .option("header", true)
      .option("inferSchema", true)
      .option("timestampFormat", "dd/MM/yyyy")
      .csv(filePath)
    println(data.count)
    data.printSchema
    data.show

    val orderedData = data.orderBy(("Date of Payment"))
    orderedData.show(5)

    
    spark.stop()
  }
}
