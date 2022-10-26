package com.example.nac.Mapper;

import com.example.nac.model.bonsche;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//회원정보를 DB와 맵핑해줌
@Mapper
public interface Joinusmapper {
    /*-------------------------- Select --------------------------*/

    //해당하는 ID가 있을 경우 true를 반환 없을경우 false를 반환
    @Select("Select count(*) as cn from JOINUS where id=#{id}")
    boolean ExistsID(@Param("id") String id);

    @Select("Select count(*) as cn from JOINUS where EMAIL=#{EMAIL}")
    boolean ExistsEmail(@Param("EMAIL") String EMAIL);

    /*-------------------------- Insert --------------------------*/
    //로그인정보 저장
    //아직 작동안함
    @Insert("INSERT INTO project2022.JOINUS " +
            "(ID, EMAIL, PASSWORD, NAME, SECURITY) " +
            "VALUES (#{ID}, #{EMAIL}, #{PASSWORD}, #{NAME}, #{SECURITY});")
    boolean SignUp(@Param("ID") String ID,
                @Param("EMAIL") String EMAIL,
                @Param("PASSWORD") String PASSWORD,
                @Param("NAME") String NAME,
                @Param("SECURITY") String SECURITY);

}
