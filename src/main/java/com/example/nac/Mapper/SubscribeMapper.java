package com.example.nac.Mapper;

import com.example.nac.model.MEMO;
import com.example.nac.model.SUBSCRIBE;
import org.apache.ibatis.annotations.*;

import java.util.List;

//DB에서 본회의 정보를 읽어와 본회의 모델 객체에 맵핑
@Mapper
public interface SubscribeMapper {
    @Insert("INSERT INTO project2022.SUBSCRIBE " +
            "(TYPE, ID, DATE, TITLE) " +
            "VALUES ('${type}', '${id}', '${date}', '${title}');")
    boolean PushSubscribe(
            @Param("type") String type,
            @Param("id") String id,
            @Param("date") String date,
            @Param("title") String title);

    @Delete("DELETE FROM project2022.SUBSCRIBE WHERE (num = #{num});")
    boolean PopSubscribe(@Param("num") String num);


    @Select("SELECT * FROM project2022.SUBSCRIBE where ID like '%${id}%'")
    List<SUBSCRIBE> GetSubscribe(@Param("id") String id);

    @Select("SELECT * FROM project2022.SUBSCRIBE where DATE like '%${date}%' and ID like #{id};")
    List<MEMO> GetSubscribeDate(@Param("date") String date, @Param("id") String id);

}
