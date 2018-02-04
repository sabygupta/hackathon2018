package com.zaloni.hackathon.catalog;

import com.zaloni.hackathon.vo.Catalog;
import com.zaloni.hackathon.vo.CatalogFields;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

import java.util.HashSet;
import java.util.Set;

public class CsvSchema extends Parser {

    public Catalog parse(String fileName) {

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

        return convertToCatalog(df, fileName);
    }
}
