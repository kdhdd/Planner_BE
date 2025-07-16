package com.example.planner_be.Dto.Place;

import com.example.planner_be.Model.Place;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePlaceDto {
    private Long id;
    private String name;
    private String areaNm;

    public static ResponsePlaceDto entityToDto(Place place) {
        return ResponsePlaceDto.builder()
                .id(place.getId())
                .name(place.getName())
                .areaNm(place.getAreaNm())
                .build();
    }
}
