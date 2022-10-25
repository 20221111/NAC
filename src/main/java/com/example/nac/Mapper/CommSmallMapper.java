package com.example.nac.Mapper;

import com.example.nac.model.CommSche_Small;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//DB에서 정기회의 정보를 읽어와 정기회의 모델 객체에 맵핑
@Mapper
public interface CommSmallMapper {
    @Select("SELECT * FROM project2022.COMMSCHE_SMALL where MEETING_DATE = #{date}")
    List<CommSche_Small> GetCommSche_SmallDate(@Param("date") String date);

    @Select("SELECT * FROM project2022.COMMSCHE_SMALL where MEETING_DATE like '%${month}%'")
    List<CommSche_Small> GetCommSche_SmallMonth(@Param("month") String month);
}
