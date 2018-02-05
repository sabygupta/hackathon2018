package com.zaloni.hackathon.catalog;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaloni.hackathon.vo.Catalog;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;

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

        Catalog catalog = convertToCatalog(df, fileName);

        postToRestApi("http://localhost:9090/api/catalog", catalog);

        return catalog;
    }
}
