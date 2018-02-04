package com.zaloni.hackathon.catalog;

import com.zaloni.hackathon.vo.Catalog;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;

public class AvroSchema extends Parser {

    public Catalog parse(String fileName) {

        SparkSession sparkSession = SparkSession.builder()
                .master("local")
                .appName("Avro Schema Parser")
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

        return convertToCatalog(df, fileName);
    }
}
