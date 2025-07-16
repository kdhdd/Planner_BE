package com.example.planner_be.Repository;

import com.example.planner_be.Model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
