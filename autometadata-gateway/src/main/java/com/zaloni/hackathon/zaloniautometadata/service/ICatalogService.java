package com.zaloni.hackathon.zaloniautometadata.service;

import com.zaloni.hackathon.vo.Catalog;

import java.util.List;


public interface ICatalogService {
    public void addCatalog(Catalog catalog);
    public List<Catalog> getCatalogs();
    public Catalog getCatalog(int id);
}
