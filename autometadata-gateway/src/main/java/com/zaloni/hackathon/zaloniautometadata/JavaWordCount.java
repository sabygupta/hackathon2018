package com.zaloni.hackathon.zaloniautometadata;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.regex.Pattern;

public class JavaWordCount {
    private static final Pattern SPACE = Pattern.compile(" ");

    public static void main(String[] args) throws Exception {

        SparkConf conf = new SparkConf().setAppName("org.sparkexample.TestCount")
                .setMaster("spark://127.0.0.1:7077");
        JavaSparkContext sc = new JavaSparkContext(conf);

    }
}
