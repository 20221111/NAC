package com.example.nac.Mapper;

import com.example.nac.model.CommSche_Kong;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//DB에서 정기회의 정보를 읽어와 정기회의 모델 객체에 맵핑
@Mapper
public interface CommKongMapper {

    @Select("SELECT * FROM COMMSCHE_KONG")
    List<CommSche_Kong> GetCommSche_KongList();

    @Select("SELECT * FROM COMMSCHE_KONG where TITLE = #{TITLE}")
    CommSche_Kong GetCommSche_KongTitle(@Param("TITLE") String TITLE);

    @Select("SELECT * FROM project2022.COMMSCHE_KONG where MEETING_DATE = #{date}")
    List<CommSche_Kong> GetCommSche_KongDate(@Param("date") String date);

    @Select("SELECT * FROM project2022.COMMSCHE_KONG where MEETING_DATE like '%${month}%'")
    List<CommSche_Kong> GetCommSche_KongMonth(@Param("month") String month);

    /* -------------------------------*/

    @Insert("INSERT INTO COMMSCHE_KONG VALUES(#{meetingsession}, #{cha}, #{title}, #{meeting_date}, #{meeting_time}, #{link_url}, #{unit_cd}, #{unit_nm})")
    int PutCOMMSCHE_KONG(@Param("meetingsession") String meetingsession,@Param("cha") String cha,@Param("title") String title, @Param("meeting_date") String meeting_date, @Param("meeting_time") String meeting_time, @Param("link_url") String link_url, @Param("unit_cd") String unit_cd, @Param("unit_nm") String unit_nm);
}
