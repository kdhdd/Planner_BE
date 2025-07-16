package com.example.planner_be.Service;

import com.example.planner_be.Dto.Place.RequestPlaceDto;
import com.example.planner_be.Dto.Place.ResponsePlaceDto;
import com.example.planner_be.Model.Place;
import com.example.planner_be.Repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public ResponsePlaceDto savePlace(RequestPlaceDto requestPlaceDto) {


        Place place = Place.signupBuilder()
                .name(requestPlaceDto.getName())
                .areaNm(requestPlaceDto.getAreaNm())
                .build();

        placeRepository.save(place);
        return ResponsePlaceDto.entityToDto(place);
    }
}
