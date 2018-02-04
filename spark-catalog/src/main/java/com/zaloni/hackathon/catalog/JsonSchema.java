package com.zaloni.hackathon.catalog;

import com.zaloni.hackathon.vo.Catalog;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;

public class JsonSchema extends Parser {

    public Catalog parse(String fileName) {

        SparkSession sparkSession = SparkSession.builder()
                .master("local")
                .appName("Json Schema Parser")
                .getOrCreate();
        Dataset<Row> df = sparkSession.read().json(fileName);
        SQLContext sqlContext = new SQLContext(sparkSession);
        /*Dataset<Row> df =
                sqlContext
                        .read()
                        .format("org.apache.spark.sql.json")
                        .load(fileName);*/
        df.printSchema();

        return convertToCatalog(df, fileName);
    }
}
