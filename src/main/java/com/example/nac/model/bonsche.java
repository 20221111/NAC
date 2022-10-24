package com.example.nac.model;

import lombok.*;

//DB의 본회의 테이블에 멥핑되는 객체
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class bonsche extends Scadule{
    private String MEETING_DATE; //날자(2022-04-04)
    private String MEETING_TIME; //10:00
    private String TITLE; //제목
    private String MEETINGSESSION; //세션(제400회국회)
    private String CHA; //차수(제 2차)
    private String LINK_URL; //링크
    private String UNIT_CD; //모르겠음(100021)
    private String UNIT_NM; //(제21대)

}
