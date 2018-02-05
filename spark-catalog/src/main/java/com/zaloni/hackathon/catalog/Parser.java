package com.zaloni.hackathon.catalog;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaloni.hackathon.vo.Catalog;
import com.zaloni.hackathon.vo.CatalogFields;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import scala.Tuple2;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
                new Catalog.CatalogBuilder(fileName)
                        .Description(fileName)
                        .DataSourceId("123")
                        .CreatedBy("me")
                        .CreatedTime(new Date(2018,1,1))
                        .Fields(catalogFieldsSet).build();

        return catalog;

    }

    protected void postToRestApi(String uri, Catalog catalog){

        ObjectMapper mapper = new ObjectMapper();
        String requestBody = null;

        URL url = null;
        try {
            requestBody = mapper.writeValueAsString(catalog);

            url = new URL(uri);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setUseCaches(false);
            con.setDoOutput(true);
            //Send request
            System.out.println("send request....");
            DataOutputStream wr = new DataOutputStream (
                    con.getOutputStream());
            wr.writeBytes(requestBody);
            wr.close();

            //Get Response
            System.out.println("receive response....");
            InputStream is = con.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            System.out.println("response: " + response);
            rd.close();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
