package com.zaloni.hackathon.catalog;

import com.zaloni.hackathon.vo.Catalog;
import com.zaloni.hackathon.vo.CatalogFields;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import scala.Tuple2;

import java.util.HashSet;
import java.util.Set;

public abstract class Parser {

    public abstract Catalog parse(String fileName);

    protected Catalog convertToCatalog(Dataset<Row> df, String fileName) {

        int index = 0;

        Set<CatalogFields> catalogFieldsSet = new HashSet<>();
        for (Tuple2<String, String> dtype : df.dtypes()) {
            CatalogFields catalogFields =
                    new CatalogFields.CatalogFieldsBuilder(index, dtype._1)
                            .FieldDataType(dtype._2)
                            .FieldPosition(index)
                            .build();
            catalogFieldsSet.add(catalogFields);

            index++;
            //System.out.println("Catalog Field: " + catalogFields);
        }

        Catalog catalog =
                new Catalog.CatalogBuilder(1, 1, fileName).Fields(catalogFieldsSet).build();

        return catalog;

    }
}
