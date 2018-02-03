package com.zaloni.hackathon.zaloniautometadata.crawler;

import com.zaloni.hackathon.zaloniautometadata.vo.Catalog;

import java.util.List;

public class JDBCCrawler extends Crawler {
    String jdbcUrl;

    @Override
    public List<Catalog> crawl() {
        //find the databases, tables and add request to queue
        return null;
    }
}
