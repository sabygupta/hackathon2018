package com.zaloni.hackathon.zaloniautometadata.service;

import com.zaloni.hackathon.vo.Catalog;
import com.zaloni.hackathon.zaloniautometadata.dao.CatalogDO;
import com.zaloni.hackathon.zaloniautometadata.dao.CatalogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CatalogService implements ICatalogService {

    @Autowired
    CatalogRepository repository;

    @Autowired
    ModelMapper mapper;

    public void addCatalog(Catalog catalog) {
        CatalogDO catalogDO = mapper.map(catalog, CatalogDO.class);
        System.out.println("Before : " + catalogDO);
        repository.save(catalogDO);
        System.out.println("After : " + catalogDO);
    }
}
