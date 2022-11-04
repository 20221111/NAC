package com.example.nac.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//DB의 구독 테이블에 멥핑되는 객체
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SUBSCRIBE {
    private String num;
    private String ID;
    private String type;
    private String date;
    private String TITLE;

}
