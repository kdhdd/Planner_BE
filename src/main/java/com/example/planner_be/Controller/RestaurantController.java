package com.example.planner_be.Controller;

import com.example.planner_be.Dto.Kcisa.KcisaResponse;
import com.example.planner_be.Service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/{placeId}")
    public ResponseEntity<KcisaResponse.Items> findRestaurants(
            @PathVariable Long placeId,
            @RequestParam String clNm,
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "10") int numOfRows) {

        return ResponseEntity.ok(
                restaurantService.getRestaurants(placeId, clNm, pageNo, numOfRows));
    }
}

