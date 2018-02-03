package com.zaloni.hackathon.zaloniautometadata.crawler;

import com.zaloni.hackathon.zaloniautometadata.vo.Catalog;

import java.util.List;

public interface ICrawler {
    public List<Catalog> crawl();
}
