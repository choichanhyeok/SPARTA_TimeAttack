package com.spring01.spring_0611.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
public class ApiResponseHeader {
    private int code;
    private String message;
}
