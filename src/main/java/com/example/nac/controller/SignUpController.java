package com.example.nac.controller;

import com.example.nac.Mapper.Joinusmapper;
import org.apache.ibatis.jdbc.Null;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/SignUp")
public class SignUpController {

    private Joinusmapper joinusmapper;

    public SignUpController(Joinusmapper joinusmapper) {
        this.joinusmapper = joinusmapper;
    }

    //현재 이 아이디로 가입한 가입자가 있는지 확인
    @GetMapping("/isId/{id}")
    public boolean IsSignUp(@PathVariable("id") String id)
    {
        return joinusmapper.ExistsID(id);
    }

    //현재 이 이메일로 가입한 가입자가 있는지 확인
    @GetMapping("/isEmail/{email}")
    public boolean ExistsEmail(@PathVariable("email") String email)
    {
        return joinusmapper.ExistsEmail(email);
    }

    //입력된 아이디, 비번, 이름, 이메일, 개인정보로 가입을 시도
    @PostMapping("/{id}")
    public int SignUp(@PathVariable("id") String id, @RequestParam("email") String email,
                       @RequestParam("password") String password, @RequestParam("name") String name,
                          @RequestParam("security") String security)
    {
        if((id == null) || (email == null) || (password == null) || (name == null) || (security == null))
        {
            return 1;
        }
        else
        {
            if (joinusmapper.ExistsEmail(email) || joinusmapper.ExistsID(id))
            {
                return 2;
            }
            else
            {
                joinusmapper.SignUp(id,email,password,name,security);
                return 0;
            }
        }
    }
}