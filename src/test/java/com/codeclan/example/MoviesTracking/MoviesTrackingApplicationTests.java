package com.codeclan.example.MoviesTracking;

import com.codeclan.example.MoviesTracking.models.Actor;
import com.codeclan.example.MoviesTracking.models.Director;
import com.codeclan.example.MoviesTracking.models.Film;
import com.codeclan.example.MoviesTracking.models.Genre;
import com.codeclan.example.MoviesTracking.repositories.ActorRepository;
import com.codeclan.example.MoviesTracking.repositories.DirectorRepository;
import com.codeclan.example.MoviesTracking.repositories.FilmRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MoviesTrackingApplicationTests {


	@Autowired
	FilmRepository filmRepository;

	@Autowired
	DirectorRepository directorRepository;

	@Autowired
	ActorRepository actorRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createFilmAndDirector(){
		Director director1 = new Director("Zack Snyder");
		directorRepository.save(director1);

		Film batmanVsSuperman = new Film("Batman Vs Superman", director1, Genre.THRILLER);
		filmRepository.save(batmanVsSuperman);
	}

	@Test
	public void addFilmsAndActors(){

		Director director1 = new Director("Zack Snyder");
		directorRepository.save(director1);

		Actor henry = new Actor("Henry Cavill", 100000);
		actorRepository.save(henry);

		Film manOfSteel = new Film("Man Of Steel", director1, Genre.THRILLER);
		filmRepository.save(manOfSteel);

		manOfSteel.addActor(henry);
		filmRepository.save(manOfSteel);
	}

	@Test
	public void canFindFilmByDirectorId(){
		List<Film> results = filmRepository.findFilmsByDirectorId(1L); // L signifies Long Id
		assertEquals("Zack Snyder", results.get(0).getDirector().getName());
	}

	@Test
	public void canFindFilmsByDirectorIdAndTitle(){
		List<Film> results = filmRepository.findFilmsByDirectorIdAndTitle(1L, "Man Of Steel");
		assertEquals("Man Of Steel", results.get(0).getTitle());
	}

	@Test
	public void canFindFilmByGenre(){
		Film results = filmRepository.findFilmByGenre(Genre.HORROR);
		assertEquals(Genre.HORROR, results.getGenre());
	}
}
