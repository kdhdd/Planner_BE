package com.example.planner_be.Service;

import com.example.planner_be.Dto.Place.ResponsePlaceDto;
import com.example.planner_be.Repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;

    public List<ResponsePlaceDto> findAllPlaces() {
        return placeRepository.findAll().stream()
                .map(ResponsePlaceDto::entityToDto)
                .collect(Collectors.toList());
    }
}
