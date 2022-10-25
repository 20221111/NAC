package com.example.nac.Mapper;

import com.example.nac.model.CommSche_Main;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//DB에서 정기회의 정보를 읽어와 정기회의 모델 객체에 맵핑
@Mapper
public interface CommMainMapper {
    @Select("SELECT * FROM project2022.COMMSCHE_MAIN where MEETING_DATE = #{date}")
    List<CommSche_Main> GetCommSche_MainDate(@Param("date") String date);

    @Select("SELECT * FROM project2022.COMMSCHE_MAIN where MEETING_DATE like '%${month}%'")
    List<CommSche_Main> GetCommSche_MainMonth(@Param("month") String month);
}
