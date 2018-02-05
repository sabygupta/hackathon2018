package com.zaloni.hackathon.zaloniautometadata.dao;


import javax.persistence.*;


/*

DROP TABLE IF EXISTS CATALOG_FIELDS;
CREATE TABLE CATALOG_FIELDS(ID INT PRIMARY KEY,
FIELD_POSITION INT,
FIELD_NAME VARCHAR(255),
        DESCRIPTION VARCHAR(255),
        FIELD_DATA_TYPE VARCHAR(255),
        DATA_SCALE INT,
        DATA_FORMAT VARCHAR(255),
        IS_PRIMARY BOOLEAN
        );

        INSERT INTO CATALOG_FIELDS VALUES(1, 1, 'Field1', 'First field', 'String', null, null, TRUE);
        INSERT INTO CATALOG_FIELDS VALUES(2, 2, 'Field2', 'Second Filed', 'integer', null, null, FALSE);

        SELECT * FROM CATALOG_FIELDS ORDER BY ID;
        UPDATE CATALOG_FIELDS SET FIELD_NAME='Hi' WHERE ID=1;
        DELETE FROM CATALOG_FIELDS WHERE ID=2;

*/

@Entity
@Table(name="CATALOG_FIELDS")
public class CatalogFieldDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int fieldPosition;
    private String fieldName;
    private String description;
    private String fieldDataType;
    private int dataScale;
    private String dataFormat;
    private boolean isPrimary;

    public int getFieldId() {
        return id;
    }

    public void setFieldId(int id) {
        this.id = id;
    }

    public int getFieldPosition() {
        return fieldPosition;
    }

    public void setFieldPosition(int fieldPosition) {
        this.fieldPosition = fieldPosition;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFieldDataType() {
        return fieldDataType;
    }

    public void setFieldDataType(String fieldDataType) {
        this.fieldDataType = fieldDataType;
    }

    public int getDataScale() {
        return dataScale;
    }

    public void setDataScale(int dataScale) {
        this.dataScale = dataScale;
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        this.isPrimary = primary;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "id=" + id +
                "fieldPosition=" + fieldPosition +
                ", fieldName='" + fieldName + '\'' +
                ", description='" + description + '\'' +
                ", fieldDataType='" + fieldDataType + '\'' +
                ", dataScale='" + dataScale + '\'' +
                ", dataFormat=" + dataFormat +
                ", isPrimary=" + isPrimary +
                '}';
    }
}
