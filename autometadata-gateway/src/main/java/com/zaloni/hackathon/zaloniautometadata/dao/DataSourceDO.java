package com.zaloni.hackathon.zaloniautometadata.dao;

import javax.persistence.*;
import java.util.Date;


/*
DROP TABLE IF EXISTS DATASOURCE;
CREATE TABLE DATASOURCE(
ID INT PRIMARY KEY,
NAME VARCHAR(255) not null,
TYPE VARCHAR(20) not null,
FILE_URI VARCHAR(1000),
JDBC_URL VARCHAR(1000),
CREATED_BY VARCHAR(100),
MODIFIED_BY VARCHAR(100),
CREATED_DATE DATE,
MODIFIED_DATE DATE);

INSERT INTO DATASOURCE VALUES(1, 'local', 'FILESYSTEM', 'data', null, 'zaloni', 'zaloni', sysdate, sysdate);
INSERT INTO DATASOURCE VALUES(2, 'HR', 'JDBC', null, 'jdbc://', 'zaloni', 'zaloni', sysdate, sysdate);
SELECT * FROM DATASOURCE ORDER BY ID;
UPDATE DATASOURCE SET NAME='local home' WHERE ID=1;
DELETE FROM DATASOURCE WHERE ID=2;
*/

@Entity
@Table(name="DATASOURCE")
public class DataSourceDO {
/*
        enum TYPE {
            DATABASE,
            FILESYSTEM,
            HDFS,
            S3
        }
*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String fileUri;
    private String jdbcUrl;
    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date modifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFileUri() {
        return fileUri;
    }

    public void setFileUri(String fileUri) {
        this.fileUri = fileUri;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}

