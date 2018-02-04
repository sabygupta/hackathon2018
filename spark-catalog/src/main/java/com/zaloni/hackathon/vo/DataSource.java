package com.zaloni.hackathon.vo;


import java.sql.Date;

/*
DROP TABLE IF EXISTS DATASOURCE;
CREATE TABLE DATASOURCE(ID INT PRIMARY KEY, NAME VARCHAR(255) not null, TYPE VARCHAR(20) not null, FILE_URI VARCHAR(1000), JDBC_URL VARCHAR(1000), CR_BY VARCHAR(100) not null, MOD_BY VARCHAR(100) not null, CR_DT DATE, MOD_DT DATE);
INSERT INTO DATASOURCE VALUES(1, 'local', 'FILESYSTEM', 'data', null, 'zaloni', 'zaloni', sysdate, sysdate);
INSERT INTO DATASOURCE VALUES(2, 'HR', 'JDBC', null, 'jdbc://', 'zaloni', 'zaloni', sysdate, sysdate);
SELECT * FROM DATASOURCE ORDER BY ID;
UPDATE DATASOURCE SET NAME='local home' WHERE ID=1;
DELETE FROM DATASOURCE WHERE ID=2;
 */

public class DataSource {
    enum TYPE {
        DATABASE,
        FILESYSTEM,
        HDFS,
        S3
    }
    public TYPE type;
    public String name;
    public String fileUri;
    public String jdbcUrl;
    public String createdBy;
    public String modifiedBy;
    public Date createdDate;
    public Date modifiedDate;
}

