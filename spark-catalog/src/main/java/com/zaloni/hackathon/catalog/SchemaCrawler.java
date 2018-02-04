package com.zaloni.hackathon.catalog;

import com.zaloni.hackathon.vo.Catalog;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class SchemaCrawler {

    //spark-submit --class com.zaloni.hackathon.catalog.SchemaCrawler --master local[*] spark-catalog-1.0-SNAPSHOT.jar
    //java -cp uber-spark-catalog-1.0-SNAPSHOT.jar com.zaloni.hackathon.catalog.SchemaCrawler
    static String directoryPath = "/root";

    public static void main(String[] args) throws Exception {

        Timer timer = new Timer();
        AvroSchema avroSchema = new AvroSchema();
        CsvSchema csvSchema = new CsvSchema();
        JsonSchema jsonSchema = new JsonSchema();

        System.out.println("scheduler initialized....");

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //Crawling code here
                Catalog catalog;
                System.out.println("crawler run started....");

                File folder = new File(directoryPath);

                for (final File fileEntry : folder.listFiles()) {

                    String fileName = fileEntry.getName();
                    String fileExtension = FilenameUtils.getExtension(fileName);
                    System.out.println("FileName: " + fileName + " with Extension: " + fileExtension);

                    switch (fileExtension.toLowerCase()) {
                        case "csv":
                            catalog = csvSchema.parse(fileName);
                            System.out.println("csv file identified ... & catlog: " + catalog.toString());
                            break;
                        case "json":
                            catalog = jsonSchema.parse(fileName);
                            System.out.println("json file identified ... & catlog: " + catalog.toString());
                            break;
                        case "avro":
                            System.out.println("avro file identified...");
                            //avroSchema.parse("");
                            break;
                        default:
                            System.out.println("no match");
                    }
                }
                System.out.println("crawler run ended....");
            }
        }, 1000, 30000);
    }
}
