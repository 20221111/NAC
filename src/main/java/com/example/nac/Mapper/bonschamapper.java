package com.example.nac.Mapper;

import com.example.nac.model.bonsche;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface bonschamapper {

    @Select("SELECT * FROM bonsche")
    List<bonsche> GetBonscheList();
    @Select("SELECT * FROM bonsche where TITLE = #{TITLE}")
    bonsche GetBonscheTitle(@Param("TITLE") String TITLE);

    @Select("SELECT * FROM bonsche where MEETING_DATE = #{date}")
    List<bonsche> GetBonscheDate(@Param("date") String date);

    @Insert("INSERT INTO bonsche VALUES(#{meetingsession}, #{cha}, #{title}, #{meeting_date}, #{meeting_time}, #{link_url}, #{unit_cd}, #{unit_nm})")
    int PutBonsche(@Param("meetingsession") String meetingsession,@Param("cha") String cha,@Param("title") String title, @Param("meeting_date") String meeting_date, @Param("meeting_time") String meeting_time, @Param("link_url") String link_url, @Param("unit_cd") String unit_cd, @Param("unit_nm") String unit_nm);
}
