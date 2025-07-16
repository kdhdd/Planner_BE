package com.example.planner_be.Code;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

// 프론트에서 받는 응답을 일정하게 유지해주기 위해
// 간단히 우리만의 알아들을 수 있는 설명과 성공 코드를 전달합니다.
// 우리 프로젝트에 맞는 성공 메시지를 전달하게 됨.

@RequiredArgsConstructor
@Getter

public enum ResponseCode {
    /**
     * User
     */
    SUCCESS_REGISTER(HttpStatus.CREATED, "회원가입을 성공했습니다."),
    SUCCESS_LOGIN(HttpStatus.OK, "로그인을 성공했습니다. 헤더 토큰을 확인하세요."),
    SUCCESS_RETRIEVE_USER(HttpStatus.OK, "유저 정보를 성공적으로 조회했습니다."),
    SUCCESS_REISSUE(HttpStatus.OK, "토큰 재발급을 성공했습니다. 헤더 토큰을 확인하세요."),
    SUCCESS_UPDATE_USER(HttpStatus.OK, "유저 정보를 성공적으로 수정했습니다."),
    SUCCESS_RETRIEVE_ALL_USERS(HttpStatus.OK, "모든 사용자를 성공적으로 조회했습니다."),
    SUCCESS_LOGOUT(HttpStatus.OK, "성공적으로 로그아웃했습니다."),
    SUCCESS_DELETE_USER(HttpStatus.OK, "유저가 성공적으로 삭제되었습니다."),


    /**
     * ProductReaction
     */

    SUCCESS_REACTION_REGISTER(HttpStatus.OK, "성공적으로 평가를 처리하였습니다."),

    /**
     * Place
     */
    SUCCESS_RETRIEVE_PLACE(HttpStatus.OK, "여행지를 성공적으로 불러왔습니다."),


    /**
     * Recommendation
     */

    SUCCESS_REGISTER_RECOMMENDATIONS(HttpStatus.OK, "레시피를 성공적으로 등록했습니다."),
    SUCCESS_RETRIEVE_RECOMMENDATION(HttpStatus.OK, "레시피를 성공적으로 불러왔습니다."),
    SUCCESS_RETRIEVE_RECOMMENDATION_LIST(HttpStatus.OK, "레시피 리스트를 성공적으로 불러왔습니다."),
    SUCCESS_RECOMMENDATION_EMPTY(HttpStatus.OK, "요청은 성공했으나, 레시피가 존재하지 않습니다."),
    SUCCESS_UPDATE_RECOMMENDATIONS(HttpStatus.OK, "레시피를 성공적으로 수정했습니다.")

    ;


    private final HttpStatus status;
    private final String message;

}
