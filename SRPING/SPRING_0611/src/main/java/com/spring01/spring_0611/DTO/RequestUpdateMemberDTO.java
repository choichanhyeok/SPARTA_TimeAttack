package com.spring01.spring_0611.DTO;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestUpdateMemberDTO {
    private String userName;
    private int userAge;
    private int gender;

    @Builder
    public RequestUpdateMemberDTO(String userName, int userAge, int gender){
        this.userName = userName;
        this.userAge = userAge;
        this.gender = gender;
    }

}
