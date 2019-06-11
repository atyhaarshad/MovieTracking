package com.codeclan.example.MoviesTracking.repositories;

import com.codeclan.example.MoviesTracking.models.Film;
import com.codeclan.example.MoviesTracking.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Enumerated;
import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {


    List<Film> findFilmsByDirectorId(Long directorId);

    List<Film> findFilmsByDirectorIdAndTitle(Long id, String title);

    Film findFilmByGenre(Genre genre);
}
