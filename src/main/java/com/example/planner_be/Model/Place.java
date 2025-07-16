package com.example.planner_be.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "places")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* 화면에 노출할 이름 (예: 제주, 경주, 부산) */
    @Column(nullable = false, length = 30)
    private String name;

    /* 외부 맛집 API 전달용 시·도/시·군·구 명 (예: 제주특별자치도, 경상북도 경주시) */
    @Column(nullable = false, length = 50)
    private String areaNm;

    @Builder(builderMethodName = "signupBuilder")
    public Place(String name, String areaNm) {
        this.name = name;
        this.areaNm = areaNm;
    }
}
