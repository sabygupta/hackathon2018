package com.zaloni.hackathon.zaloniautometadata.service;

import com.zaloni.hackathon.zaloniautometadata.dao.DataSourceDO;

import java.util.List;

public interface IDataSourceService {
    public void addDataSource(DataSourceDO dataSource);
    public List<DataSourceDO> getDataSources();
}
