package com.example.planner_be.Controller;

import com.example.planner_be.Code.ResponseCode;
import com.example.planner_be.Dto.Place.ResponsePlaceDto;
import com.example.planner_be.Dto.Response.ResponseDTO;
import com.example.planner_be.Service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/places")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping
    public ResponseEntity<ResponseDTO<List<ResponsePlaceDto>>> getAllPlaces() {
        List<ResponsePlaceDto> response = placeService.findAllPlaces();
        return ResponseEntity.ok(new ResponseDTO<>(ResponseCode.SUCCESS_RETRIEVE_PLACE, response));
    }
}
