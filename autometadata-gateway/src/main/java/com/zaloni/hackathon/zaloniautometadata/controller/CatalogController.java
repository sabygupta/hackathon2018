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
            System.out.println("request received....");
            catalogService.addCatalog(catalog);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch(Exception e)  {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }

    @RequestMapping(value = "/api/catalog", method = RequestMethod.GET, produces = "application/json")
    public String getCatalogs() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(catalogService.getCatalogs());
        } catch(Exception e)  {
            e.printStackTrace();
            return "Error";
        }
    }

    @RequestMapping(value = "/api/catalog/{id}", method = RequestMethod.GET, produces = "application/json")
    public String getCatalog(@PathVariable("id") int id) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Catalog c = catalogService.getCatalog(id);
            return c != null?mapper.writeValueAsString(catalogService.getCatalog(id)):"{}";
        } catch(Exception e)  {
            e.printStackTrace();
            return "Error";
        }
    }


}
