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
public class COMMSCHE_KONG extends Scadule{
    private String MEETING_DATE; //날자(2022-04-04)
    private String MEETING_TIME; //10:00
    private String TITLE; //제목
    private String SESS;
    private String COMMITTEE_NAME;
    private String LINK_URL2;
    private String UNIT_CD;
    private String UNIT_NM;
    private String HR_DEPT_CD;

}
