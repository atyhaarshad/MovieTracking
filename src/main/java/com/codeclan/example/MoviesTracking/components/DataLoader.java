package com.codeclan.example.MoviesTracking.components;

import com.codeclan.example.MoviesTracking.models.Actor;
import com.codeclan.example.MoviesTracking.models.Director;
import com.codeclan.example.MoviesTracking.models.Film;
import com.codeclan.example.MoviesTracking.models.Genre;
import com.codeclan.example.MoviesTracking.repositories.ActorRepository;
import com.codeclan.example.MoviesTracking.repositories.DirectorRepository;
import com.codeclan.example.MoviesTracking.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    ActorRepository actorRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

        Director director1 = new Director("Zack Snyder");
        directorRepository.save(director1);

        Actor henry = new Actor("Henry Cavill", 100000);
        actorRepository.save(henry);

        Actor affleck = new Actor("Ben Affleck", 500000);
        actorRepository.save(affleck);

        Actor amy = new Actor("Amy Adams", 250000);
        actorRepository.save(amy);

        Film batmanVsSuperman = new Film("Batman Vs Superman", director1, Genre.THRILLER);
        filmRepository.save(batmanVsSuperman);

        Film test = new Film("Test", director1, Genre.HORROR);
        filmRepository.save(test);

        Film manOfSteel = new Film("Man Of Steel", director1, Genre.THRILLER);
        filmRepository.save(manOfSteel);

        affleck.addFilm(batmanVsSuperman);
        henry.addFilm(batmanVsSuperman);
        filmRepository.save(batmanVsSuperman);
        actorRepository.save(affleck);
        actorRepository.save(henry);

        manOfSteel.addActor(amy);
        filmRepository.save(manOfSteel);





    }
}
