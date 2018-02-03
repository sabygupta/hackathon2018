package com.zaloni.hackathon.zaloniautometadata.vo;

import java.util.Date;
import java.util.Set;

public class Catalog {

    private int id;

    private int version;

    private String businessName;

    private String technicalName;

    private String description;

    private String subjectArea;

    private String label;

    private String frequencyOfUpdate;

    private String sourceSystem;

    private String primaryKey;

    private String sourcePlatform;

    private String targetSourceSchema;

    private String sourceSchema;

    private String loadType;

    private String createdBy;

    private Date createdTime;

    private String modifiedBy;

    private Date modifiedTime;

    private boolean latestVersion;

    private boolean hasCDCAction;

    private boolean hasInactiveTable;

    private boolean derived;

    private Date ingestionTime;

    private String owner;

    private Set<CatalogFields> fields;

    //private DataFileType dataFileType;

    private Integer dataFileRecordLength;

    private String tableType;
}
