package com.zaloni.hackathon.zaloniautometadata.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DataSourceRepository extends CrudRepository<DataSourceDO, Long> {
    List<DataSourceDO> findById(Long id);
    List<DataSourceDO> findAll();
    DataSourceDO save(DataSourceDO dataSource);
}
