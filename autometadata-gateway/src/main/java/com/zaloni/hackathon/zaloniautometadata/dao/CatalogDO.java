package com.zaloni.hackathon.zaloniautometadata.dao;

import com.zaloni.hackathon.vo.CatalogFields;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/*
DROP TABLE IF EXISTS CATALOG;
        CREATE TABLE CATALOG(ID INT PRIMARY KEY, NAME VARCHAR(255),
        DESCRIPTION VARCHAR(255),
        DATASOURCE_ID INT,
        CREATED_BY VARCHAR(255),
        CREATED_TIME TIMESTAMP
        );

        INSERT INTO CATALOG VALUES(1, 'Entity1', 'First Entity', 1, 'zaloni', sysdate);
        INSERT INTO CATALOG VALUES(2, 'Entity2', 'Second Entity', 1, 'zaloni', sysdate);

        SELECT * FROM CATALOG ORDER BY ID;
        UPDATE CATALOG SET NAME='Hi' WHERE ID=1;
        DELETE FROM CATALOG WHERE ID=2;
*/

@Entity
@Table(name="CATALOG")
public class CatalogDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;

    private int dataSourceId;
    private String createdBy;
    private Date createdTime;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "CATALOG_ID")
    private Set<CatalogFieldDO> fields;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDataSourceId() {
        return dataSourceId;
    }

    public void setDataSourceId(int dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Set<CatalogFieldDO> getFields() {
        return fields;
    }

    public void setFields(Set<CatalogFieldDO> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dataSourceId='" + dataSourceId + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", fields=" + fields +
                '}';
    }


}
