package com.insights.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.insights.dao.entities.MovieEntity;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Movie {
    public Movie(MovieEntity entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.violence = entity.getViolence();
        this.rate = entity.getRate();
        this.frightening = entity.getFrightening();
        this.nudity = entity.getNudity();
        this.alcohol = entity.getAlcohol();
        this.duration = entity.getDuration();
        this.date = entity.getDate();
        this.type = entity.getType();
        this.episodes = entity.getEpisodes();
        this.votes = entity.getVotes();
        this.genre = entity.getGenre();
        this.profanity = entity.getProfanity();
        this.certificate = entity.getCertificate();
    }

    private String id;

    private String name;

    private String violence;

    private float rate;

    private String frightening;

    private String nudity;

    private String alcohol;

    private int duration;

    private int date;

    private String type;

    private String episodes;

    private String votes;

    private String genre;

    private String profanity;

    private String certificate;
}
