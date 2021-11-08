package com.insights.models;

import org.springframework.data.solr.core.query.result.FacetFieldEntry;

import java.util.Map;

public abstract class Bin {

    protected  String rangeDef = "";

    protected long count = 0;

    public Bin(Map<String, String> rangeTranslation, String rangeDef, long count){
        this.rangeDef = rangeTranslation.get(rangeDef);
        this.count = count;
    }
}
