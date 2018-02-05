package com.zaloni.hackathon.zaloniautometadata.service;

import com.zaloni.hackathon.zaloniautometadata.dao.DataSourceDO;
import com.zaloni.hackathon.zaloniautometadata.dao.DataSourceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSourceService implements IDataSourceService {

    @Autowired
    DataSourceRepository repository;


    public void addDataSource(DataSourceDO dataSource) {
        //DataSourceDO dataSource = mapper.map(catalog, CatalogDO.class);
        System.out.println("Before : " + dataSource);
        repository.save(dataSource);
        System.out.println("After : " + dataSource);
    }

    public List<DataSourceDO> getDataSources() {
        System.out.println("In getDataSources");
        return repository.findAll();
    }


}
