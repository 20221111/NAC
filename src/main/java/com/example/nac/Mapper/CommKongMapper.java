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
    @Select("SELECT * FROM project2022.COMMSCHE_KONG where MEETING_DATE = #{date}")
    List<CommSche_Kong> GetCommSche_KongDate(@Param("date") String date);

    @Select("SELECT * FROM project2022.COMMSCHE_KONG where MEETING_DATE like '%${month}%'")
    List<CommSche_Kong> GetCommSche_KongMonth(@Param("month") String month);
}
