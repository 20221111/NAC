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
public class PERFORMANCE {
    private String ARTICLE_TITLE;
    private String RE_DT;
    private String DT;
    private String ETC_CHAR11;
    private String LINK_URL;

}
