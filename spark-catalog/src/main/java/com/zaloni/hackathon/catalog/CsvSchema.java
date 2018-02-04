package com.zaloni.hackathon.catalog;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;

public class CsvSchema implements Parser {

    public boolean parse(String fileName) {

        SparkSession sparkSession = SparkSession.builder()
                .master("local")
                .appName("Csv Schema Parser")
                .getOrCreate();
        SQLContext sqlContext = new SQLContext(sparkSession);
        Dataset<Row> df =
                sqlContext
                        .read()
                        .format("com.databricks.spark.csv")
                        .option("header", "true")
                        .option("inferSchema", "true")
                        .load(fileName);
        df.printSchema();
        System.out.println((df.dtypes()[0])._1);

        return false;
    }
}
