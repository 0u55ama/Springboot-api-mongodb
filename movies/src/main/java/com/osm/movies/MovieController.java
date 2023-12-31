package com.osm.movies;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @CrossOrigin(origins = "*") // Allow requests from any origin
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*") // Allow requests from any origin
    @GetMapping("/{ImdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String ImdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(ImdbId), HttpStatus.OK);
    }
}
