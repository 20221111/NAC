package com.example.nac.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//DB의 일반스케줄 테이블에 멥핑되는 객체
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SEMINAR {
    private String SDATE;
    private String STIME;
    private String NAME;
    private String TITLE;
    private String LOCATION;
    private String LINK;
    private String DESCRIPTION;

}
