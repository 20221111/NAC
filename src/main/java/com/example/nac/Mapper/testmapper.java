package com.example.nac.Mapper;

import com.example.nac.model.bonsche;
import com.example.nac.model.test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface testmapper {
    @Select("SELECT * FROM test where name = #{name}")
    test GettestID(@Param("name") String name);

    @Select("SELECT * FROM test")
    List<test> Gettestall();
}
