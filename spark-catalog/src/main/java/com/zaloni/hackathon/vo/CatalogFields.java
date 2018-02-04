package com.zaloni.hackathon.vo;

public class CatalogFields {

    private int fieldId;
    private int fieldPosition;
    private String fieldName;
    private String description;
    private String fieldDataType;
    private int dataScale;
    private String dataFormat;
    private boolean primary;

    public CatalogFields(CatalogFieldsBuilder catalogFieldsBuilder) {

        this.fieldId = catalogFieldsBuilder.fieldId;
        this.fieldName = catalogFieldsBuilder.fieldName;
        this.fieldDataType = catalogFieldsBuilder.fieldDataType;
        this.fieldPosition = catalogFieldsBuilder.fieldPosition;
    }

    public int getFieldId() {
        return fieldId;
    }

    public int getFieldPosition() {
        return fieldPosition;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getDescription() {
        return description;
    }

    public int getDataScale() {
        return dataScale;
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public boolean isPrimary() {
        return primary;
    }


    public static class CatalogFieldsBuilder {

        private int fieldId;
        private int fieldPosition;
        private String fieldName;
        private String description;
        private String fieldDataType;
        private int dataScale;
        private String dataFormat;
        private boolean primary;

        public CatalogFieldsBuilder(int fieldId, String fieldName) {

            this.fieldId = fieldId;
            this.fieldName = fieldName;
        }

        public CatalogFieldsBuilder FieldId(int fieldId) {
            this.fieldId = fieldId;
            return this;
        }

        public CatalogFieldsBuilder FieldPosition(int fieldPosition) {
            this.fieldPosition = fieldPosition;
            return this;
        }

        public CatalogFieldsBuilder Description(String description) {
            this.description = description;
            return this;
        }

        public CatalogFieldsBuilder FieldDataType(String fieldDataType) {
            this.fieldDataType = fieldDataType;
            return this;
        }

        public CatalogFieldsBuilder DataScale(int dataScale) {
            this.dataScale = dataScale;
            return this;
        }

        public CatalogFieldsBuilder DataFormat(String dataFormat) {
            this.dataFormat = dataFormat;
            return this;
        }

        public CatalogFieldsBuilder Primary(boolean primary) {
            this.primary = primary;
            return this;
        }

        public CatalogFields build() {
            return new CatalogFields(this);
        }
    }
}
