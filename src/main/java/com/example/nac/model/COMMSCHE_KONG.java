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
public class COMMSCHE_KONG {
    private String MEETING_DATE;
    private String MEETING_TIME;
    private String SESS;
    private String TITLE;
    private String COMMITTEE_NAME;
    private String LINK_URL2;
    private String UNIT_CD;
    private String UNIT_NM;
    private String HR_DEPT_CD;

}
