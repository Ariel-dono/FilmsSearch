package com.insights.dao.entities;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "movies")
public class MovieEntity {
    @Id
    @Indexed(name = "id", type = "string")
    @Getter
    private String id;

    @Indexed(name = "name", type = "string")
    @Getter
    private String name;

    @Indexed(name = "violence", type = "string")
    @Getter
    private String violence;

    @Indexed(name = "normalizedRate", type = "pfloat")
    @Getter
    private float rate;

    @Indexed(name = "frightening", type = "string")
    @Getter
    private String frightening;

    @Indexed(name = "nudity", type = "string")
    @Getter
    private String nudity;

    @Indexed(name = "alcohol", type = "string")
    @Getter
    private String alcohol;

    @Indexed(name = "normalizedDuration", type = "pint")
    @Getter
    private int duration;

    @Indexed(name = "date", type = "pint")
    @Getter
    private int date;

    @Indexed(name = "type", type = "string")
    @Getter
    private String type;

    @Indexed(name = "episodes", type = "string")
    @Getter
    private String episodes;

    @Indexed(name = "votes", type = "string")
    @Getter
    private String votes;

    @Indexed(name = "genre", type = "string")
    @Getter
    private String genre;

    @Indexed(name = "profanity", type = "string")
    @Getter
    private String profanity;

    @Indexed(name = "certificate", type = "string")
    @Getter
    private String certificate;
}
