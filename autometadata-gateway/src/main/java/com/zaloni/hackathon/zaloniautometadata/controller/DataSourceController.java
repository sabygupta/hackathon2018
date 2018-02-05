package com.zaloni.hackathon.zaloniautometadata.controller;

import com.zaloni.hackathon.vo.Catalog;
import com.zaloni.hackathon.zaloniautometadata.dao.DataSourceDO;
import com.zaloni.hackathon.zaloniautometadata.service.ICatalogService;
import com.zaloni.hackathon.zaloniautometadata.service.IDataSourceService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataSourceController {

    @Autowired
    IDataSourceService dataSourceService;

    @RequestMapping(value = "/api/datasource", method = RequestMethod.POST)
    public ResponseEntity<String> addCatalog(@RequestBody DataSourceDO dataSource) {
        try {
            dataSourceService.addDataSource(dataSource);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch(Exception e)  {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }

    @RequestMapping(value = "/api/datasource", method = RequestMethod.GET, produces = "application/json")
    public String getDataSources() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(dataSourceService.getDataSources());
        } catch(Exception e)  {
            return "Error";
        }
    }


}
