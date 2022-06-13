package com.spring01.spring_0611.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring01.spring_0611.DTO.RequestUpdateMemberDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    @Id
    private Long idx;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private int userAge;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Builder
    public Member(String userEmail, String userName, int userAge, Gender gender){
        this.userEmail = userEmail;
        this.userName = userName;
        this.userAge = userAge;
        this.gender = gender;
    }

    public void updateProfile(RequestUpdateMemberDTO requestUpdateMemberDTO){
        this.userName = requestUpdateMemberDTO.getUserName();
        this.userAge = requestUpdateMemberDTO.getUserAge();
        this.gender = requestUpdateMemberDTO.getGender() == 0 ? Gender.M : Gender.F;
    }
}