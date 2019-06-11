package com.codeclan.example.MoviesTracking.repositories;

import com.codeclan.example.MoviesTracking.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
