package com.example.planner_be.Service;

import com.example.planner_be.Dto.Kcisa.KcisaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class KcisaClient {

    private final WebClient webClient;

    @Value("${kcisa.service-key}")
    private String serviceKey;

    public KcisaResponse fetchRestaurants(String areaNm, String clNm, int pageNo, int numOfRows) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("serviceKey", serviceKey)
                        .queryParam("numOfRows", numOfRows)
                        .queryParam("pageNo", pageNo)
                        .queryParam("areaNm", areaNm)
                        .queryParam("clNm", clNm)
                        .build())
                .retrieve()
                .bodyToMono(KcisaResponse.class)
                .block();
    }
}
