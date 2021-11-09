package com.insights.services;

import com.insights.dao.entities.MovieEntity;
import com.insights.dao.repositories.FacetingCustomRepository;
import com.insights.dao.repositories.MovieRepository;
import com.insights.models.DurationBin;
import com.insights.models.RateBin;
import com.insights.models.Movie;
import org.apache.solr.common.params.FacetParams;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
/*
* Service dealing with Flux and Mono and data conversion as well for retrieving semantic information
*/
@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final FacetingCustomRepository facetingRepository;

    public MovieService(MovieRepository movieRepository, FacetingCustomRepository facetingRepository) {
        this.movieRepository = movieRepository;
        this.facetingRepository = facetingRepository;
    }

    public Flux<Movie> find(int page, int pageSize, String name) {
        try {
            return Flux.fromIterable(this.movieRepository.findByNameQuery(name, PageRequest.of(page, pageSize, Sort.Direction.DESC, "date")).map(Movie::new));
        }catch (Exception err){
            return Flux.error(err);
        }
    }

    public Flux<Movie> findByRateRangeAndGenre(int page, int pageSize, int bottomRate, int topRate, String genre) {
        try {
            return Flux.fromIterable(this.movieRepository.findByRateRangeAndGenre(bottomRate, topRate, genre, PageRequest.of(page, pageSize)).map(Movie::new));
        }catch (Exception err){
            return Flux.error(err);
        }
    }

    public Flux<Movie> findDurationRangeAndType(int page, int pageSize, int bottomDuration, int topDuration, String type) {
        try {
            return Flux.fromIterable(this.movieRepository.findDurationRangeAndType(bottomDuration, topDuration, type, PageRequest.of(page, pageSize)).map(Movie::new));
        }catch (Exception err){
            return Flux.error(err);
        }
    }

    public Flux<RateBin> getRateBins(){
        try {
            return Flux.fromIterable(
                    this.facetingRepository
                            .<MovieEntity>getFacetByRange("movies", "normalizedRate", 0, 10, 2, FacetParams.FacetRangeOther.BEFORE, MovieEntity.class)
                            .map(RateBin::new)
            );
        }catch (Exception err){
            return Flux.error(err);
        }
    }

    public Flux<DurationBin> getDurationBins(){
        try {
            return Flux.fromIterable(
                    this.facetingRepository
                            .<MovieEntity>getFacetByRange("movies", "normalizedDuration", 0, 240, 60, FacetParams.FacetRangeOther.ALL, MovieEntity.class)
                            .map(DurationBin::new)
            );
        }catch (Exception err){
            return Flux.error(err);
        }
    }
}
