package com.example.nac.Mapper;

import com.example.nac.model.Scadule;
import com.example.nac.model.bonsche;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//DB에서 본회의 정보를 읽어와 본회의 모델 객체에 맵핑
@Mapper
public interface bonschamapper {

    //현재 본회의 스케줄을 전부 가져옴
    @Select("SELECT * FROM bonsche")
    List<bonsche> GetbonscheList();
    
    //본회의 스케줄 제목을 확인해 가져옴
    @Select("SELECT * FROM bonsche where TITLE = #{TITLE}")
    bonsche GetbonscheTitle(@Param("TITLE") String TITLE);

    //현재 날자의 본회의 스케줄을 전부 가져옴
    @Select("SELECT * FROM project2022.bonsche where MEETING_DATE like #{date};")
    List<bonsche> GetbonscheDate(@Param("date") String date);

    //해당 한달간의 본회의 스케줄을 전부 가져옴(입력 예시: 2022-01)
    //문제 있음 실행 불가
    //%를 붙이는게 문제가 되는걸로 보임
    @Select("SELECT * FROM project2022.bonsche where MEETING_DATE like #{month}%;")
    List<bonsche> GetbonscheMonth(@Param("month") String month);

    /* 여기부터 아래는 테스트 코드*/
    @Insert("INSERT INTO bonsche VALUES(#{meetingsession}, #{cha}, #{title}, #{meeting_date}, #{meeting_time}, #{link_url}, #{unit_cd}, #{unit_nm})")
    int Putbonsche(@Param("meetingsession") String meetingsession,@Param("cha") String cha,@Param("title") String title, @Param("meeting_date") String meeting_date, @Param("meeting_time") String meeting_time, @Param("link_url") String link_url, @Param("unit_cd") String unit_cd, @Param("unit_nm") String unit_nm);
}
