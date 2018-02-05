package com.zaloni.hackathon.zaloniautometadata.service;

import com.zaloni.hackathon.vo.Catalog;
import com.zaloni.hackathon.zaloniautometadata.dao.CatalogDO;
import com.zaloni.hackathon.zaloniautometadata.dao.CatalogRepository;
import com.zaloni.hackathon.zaloniautometadata.dao.DataSourceDO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<Catalog> getCatalogs() {
        System.out.println("In getCatalogs");
        List<CatalogDO> list = repository.findAll();
        System.out.println("List : " + list);
        List<Catalog> returnList = new ArrayList<Catalog>();
        list.stream().forEach(catalogDO -> {
            returnList.add(mapper.map(catalogDO, Catalog.class));
        });
        return returnList;
    }

    public Catalog getCatalog(int id) {
        System.out.println("In getCatalog.....");
        List<CatalogDO> list = repository.findById(id);
        if(list == null || list.isEmpty()) {
            return null;
        } else {
            return mapper.map(list.get(0), Catalog.class);
        }
    }


}
