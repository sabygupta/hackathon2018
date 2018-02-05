package com.zaloni.hackathon.zaloniautometadata.controller;

import com.zaloni.hackathon.vo.Catalog;
import com.zaloni.hackathon.zaloniautometadata.service.CatalogService;
import com.zaloni.hackathon.zaloniautometadata.service.ICatalogService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CatalogController {

    @Autowired
    ICatalogService catalogService;

    @RequestMapping(value = "/api/catalog", method = RequestMethod.POST)
    public ResponseEntity<String> addCatalog(@RequestBody Catalog catalog) {
        try {
//            final Catalog catalog =	new ObjectMapper().readValue(catalogJSON, Catalog.class);
            catalogService.addCatalog(catalog);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch(Exception e)  {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }
}
