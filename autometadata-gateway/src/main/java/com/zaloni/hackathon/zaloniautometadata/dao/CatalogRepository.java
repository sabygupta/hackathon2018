package com.zaloni.hackathon.zaloniautometadata.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CatalogRepository extends CrudRepository<CatalogDO, Integer> {
        List<CatalogDO> findById(Integer id);
        CatalogDO save(CatalogDO catalogDO);
}
