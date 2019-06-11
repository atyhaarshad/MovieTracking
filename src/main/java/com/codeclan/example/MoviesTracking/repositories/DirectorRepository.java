package com.codeclan.example.MoviesTracking.repositories;

import com.codeclan.example.MoviesTracking.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {

}
