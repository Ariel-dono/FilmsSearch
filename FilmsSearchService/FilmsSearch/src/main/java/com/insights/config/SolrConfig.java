package com.insights.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

/*
* Setting up the Solr connection
*/
@Configuration
@EnableSolrRepositories(
        basePackages = "com.insights.dao.repositories",
        namedQueriesLocation = "classpath:solr-named-queries.properties"
)
@ComponentScan
public class SolrConfig {
    @Value("${solr.url}")
    private String solrUrl;

    @Bean
    public SolrClient solrClient() {
        return new HttpSolrClient.Builder(this.solrUrl).build();
    }

    @Bean
    public SolrTemplate solrTemplate(SolrClient client) throws Exception {
        return new SolrTemplate(client);
    }
}
