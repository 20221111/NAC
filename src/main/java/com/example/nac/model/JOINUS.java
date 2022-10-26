package com.example.nac.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

//DB의 일반스케줄 테이블에 멥핑되는 객체
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JOINUS {
    @Id
    private String ID;
    private String EMAIL;
    private String PASSWORD;
    private String NAME;
    private String SECURITY;

}
