package com.insights.dao.repositories;

import com.insights.dao.entities.MovieEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface MovieRepository extends SolrCrudRepository<MovieEntity, String> {
    @Query(name = "movie.findByName")
    public Page<MovieEntity> findByNameQuery(String searchTerm, Pageable pageable);

    @Query(name = "movie.findRateRangeAndGenre")
    public Page<MovieEntity> findByRateRangeAndGenre(int bottomRate, int topRate, String searchTerm, Pageable pageable);

    @Query(name = "movie.findDurationRangeAndType")
    public Page<MovieEntity> findDurationRangeAndType(int bottomDuration, int topDuration, String searchTerm, Pageable pageable);
}
