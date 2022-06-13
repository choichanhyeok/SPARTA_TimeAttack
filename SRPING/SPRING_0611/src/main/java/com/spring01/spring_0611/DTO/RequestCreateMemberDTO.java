package com.spring01.spring_0611.DTO;


import lombok.Builder;
import lombok.Getter;

@Getter
public class RequestCreateMemberDTO {
    private String userEmail;
    private String userName;
    private int userAge;
    private int gender;

    @Builder
    public RequestCreateMemberDTO(String userEmail, String userName, int userAge, int gender){
        this.userEmail = userEmail;
        this.userName = userName;
        this.userAge = userAge;
        this.gender = gender;
    }
}
