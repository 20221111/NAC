package com.example.nac.Mapper;

import com.example.nac.model.MEMO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//DB에서 본회의 정보를 읽어와 본회의 모델 객체에 맵핑
@Mapper
public interface memomapper {
    //현재 날자의 본회의 스케줄을 전부 가져옴
    @Select("SELECT * FROM project2022.bonsche where MEETING_DATE = #{date};")
    List<MEMO> GetbonscheDate(@Param("date") String date);

    //해당 한달간의 본회의 스케줄을 전부 가져옴(입력 예시: 2022-01)
    @Select("SELECT * FROM project2022.bonsche where MEETING_DATE like '%${month}%'")
    List<MEMO> GetbonscheMonth(@Param("month") String month);
}
