package com.zaloni.hackathon.vo;

import java.util.Date;
import java.util.Set;

public class Catalog {

    private int id;
    private String name;
    private String description;
    private String dataSourceId;
    private String createdBy;
    private Date createdTime;
    private Set<CatalogFields> fields;

    public Catalog() {
    }

    public Catalog(CatalogBuilder catalogBuilder){
        this.name = catalogBuilder.name;
        this.fields = catalogBuilder.fields;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDataSourceId() {
        return dataSourceId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public Set<CatalogFields> getFields() {
        return fields;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDataSourceId(String dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public void setFields(Set<CatalogFields> fields) {
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

    public static class CatalogBuilder {

        private String name;
        private String description;
        private String dataSourceId;
        private String createdBy;
        private Date createdTime;
        private Set<CatalogFields> fields;


        public CatalogBuilder(String name){
            this.name = name;
        }

        public CatalogBuilder Name(String name) {
            this.name = name;
            return this;
        }

        public CatalogBuilder Description(String description) {
            this.description = description;
            return this;
        }

        public CatalogBuilder DataSourceId(String dataSourceId) {
            this.dataSourceId = dataSourceId;
            return this;
        }

        public CatalogBuilder CreatedBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public CatalogBuilder CreatedTime(Date createdTime) {
            this.createdTime = createdTime;
            return this;
        }

        public CatalogBuilder Fields(Set<CatalogFields> fields) {
            this.fields = fields;
            return this;
        }

        public Catalog build() {
            return new Catalog(this);
        }
    }
}
