package com.insights.controllers;

import com.insights.models.DurationBin;
import com.insights.models.RateBin;
import com.insights.models.Movie;
import com.insights.services.MovieService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

/*
* Movies API endpoints definition:
*/
@CrossOrigin
@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    /*
    * Data filtered by name and ordered by date
    */
    @GetMapping(value = "/orderedbydate")
    public Flux<Movie> getByName(@RequestHeader int page, @RequestHeader int pageSize, @RequestHeader String name) {
        return service.find(page, pageSize, name);
    }

    /*
    * Filtered by rate range and genre
    */
    @GetMapping(value = "/raterange/genre")
    public Flux<Movie> findByRateRangeAndGenre(@RequestHeader int page, @RequestHeader int pageSize, @RequestHeader int bottomRate, @RequestHeader int topRate, @RequestHeader String genre) {
        return service.findByRateRangeAndGenre(page, pageSize, bottomRate, topRate, genre);
    }

    /*
     * Filtered by duration range and type (series or film)
     */
    @GetMapping(value = "/dutationrange/type")
    public Flux<Movie> findDurationRangeAndType(@RequestHeader int page, @RequestHeader int pageSize, @RequestHeader int bottomDuration, @RequestHeader int topDuration, @RequestHeader String type) {
        return service.findDurationRangeAndType(page, pageSize, bottomDuration, topDuration, type);
    }

    /*
     * Counts grouped by rate ranges
     */
    @GetMapping(value = "/ratebins")
    public Flux<RateBin> getRateBins() {
        return service.getRateBins();
    }

    /*
     * Counts grouped by duration ranges
     */
    @GetMapping(value = "/durationbins")
    public Flux<DurationBin> getDurationBins() {
        return service.getDurationBins();
    }
}
