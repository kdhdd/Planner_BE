package com.example.planner_be.Service;

import com.example.planner_be.Dto.Kcisa.KcisaResponse;
import com.example.planner_be.Model.Place;
import com.example.planner_be.Repository.PlaceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantService {

    private final PlaceRepository placeRepository;
    private final KcisaClient kcisaClient;

    public KcisaResponse.Items getRestaurants(Long placeId,
                                                   String clNm,
                                                   int pageNo,
                                                   int numOfRows) {

        Place place = placeRepository.findById(placeId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Place not found: " + placeId));

        // (선택) FoodCategory.from(clNm) 로 검증
        KcisaResponse response = kcisaClient.fetchRestaurants(
                place.getName(), clNm, pageNo, numOfRows);

        return response.getBody()
                .getItems();
    }
}
