package com.example.planner_be.Dto.Kcisa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.util.List;

@JsonRootName("response")    // `response` 래퍼 제거용
@Data
public class KcisaResponse {

    @JsonIgnore
    private Header header;

    private Body   body;

    /* --------------- header --------------- */
    @Data
    public static class Header {
        private String resultCode;
        private String resultMsg;
    }

    /* --------------- body --------------- */
    @Data
    public static class Body {
        private Items items;
    }

    /* --------------- items --------------- */
    @Data
    public static class Items {
        @JsonProperty("item")          // (C) 실제 배열 키
        private List<Item> list;       // 사용 편의를 위해 이름을 list 로
    }

    /* --------------- item --------------- */
    @Data
    public static class Item {
        // ▶ 시티투어(코스) 정보
        private String title;
        private String description;
        private String subDescription;
        private String reference;
        private String rights;
        private String source;
        private String spatial;
        private String dataStdDt;
        private String dataOfferInst;

        // ▶ 음식점 정보
        private String rstrNm;
        private String rstrBhfNm;          // null 가능
        private String rstrAsstnNm;        // null 가능
        private String rstrClNm;
        private String rstrRoadAddr;
        private String rstrLnbrAddr;
        private String rstrPnu;
        private String rstrLatPos;
        private String rstrLotPos;
        private String rstrGidCd;
        private String rstrInfoStdDt;
    }
}
