package com.insights.dao.repositories;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.params.FacetParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.convert.SolrConverter;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.FacetOptions;
import org.springframework.data.solr.core.query.SimpleFacetQuery;
import org.springframework.data.solr.core.query.SimpleStringCriteria;
import org.springframework.data.solr.core.query.result.FacetFieldEntry;
import org.springframework.stereotype.Component;

@Component
public class FacetingCustomRepository {
    private SolrOperations solrOperations;
    private String solrUrl;

    public FacetingCustomRepository(SolrOperations solrOperations){
        this.solrOperations = solrOperations;
        this.solrUrl = "http://localhost:8983/solr/";
    }

    public <T> Page<FacetFieldEntry> getFacetByRange(String collection, String fieldName, int start, int end, int gap, FacetParams.FacetRangeOther other, Class<T> clazz){
        FacetOptions facetOptions = new FacetOptions()
                .addFacetByRange(
                        new FacetOptions.FieldWithNumericRangeParameters(fieldName, start, end, gap)
                                .setOther(other)
                );
        facetOptions.setFacetMinCount(0);

        Criteria criteria = new SimpleStringCriteria("*:*");
        SimpleFacetQuery facetQuery = new SimpleFacetQuery(criteria).setFacetOptions(facetOptions);
        facetQuery.setPageRequest(PageRequest.ofSize(1));
        SolrTemplate solrTemplate = new SolrTemplate(new HttpSolrClient.Builder(this.solrUrl).build());
        SolrConverter converter = this.solrOperations.getConverter();
        solrTemplate.setSolrConverter(converter);
        solrTemplate.setMappingContext(converter.getMappingContext());
        return solrTemplate.queryForFacetPage(collection, facetQuery, clazz).getRangeFacetResultPage(fieldName);
    }
}
