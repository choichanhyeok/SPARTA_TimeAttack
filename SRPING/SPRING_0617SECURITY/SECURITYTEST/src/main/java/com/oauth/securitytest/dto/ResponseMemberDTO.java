package com.oauth.securitytest.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseMemberDTO {
    private String userEmail;
    private String userName;
    private int userAge;
    private int gender;

    @Builder
    public ResponseMemberDTO(String userEmail, String userName, int userAge, int gender){
        this.userEmail = userEmail;
        this.userName = userName;
        this.userAge = userAge;
        this.gender = gender;
    }
}

