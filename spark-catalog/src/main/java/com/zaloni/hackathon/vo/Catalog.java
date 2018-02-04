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

    public Catalog(CatalogBuilder catalogBuilder){
        this.id = catalogBuilder.id;
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

        private int id;
        private String name;
        private String description;
        private String dataSourceId;
        private String createdBy;
        private Date createdTime;
        private Set<CatalogFields> fields;

        public CatalogBuilder(int id, int version, String name){
            this.id = id;
            this.name = name;
        }

        public CatalogBuilder Id(int id) {
            this.id = id;
            return this;
        }

        public CatalogBuilder Name(String name) {
            this.name = name;
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
