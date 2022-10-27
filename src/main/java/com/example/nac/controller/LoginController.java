package com.example.nac.controller;

import com.example.nac.Mapper.*;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping(value = "/Login")
public class LoginController {
    private Joinusmapper joinusmapper;

    public LoginController(Joinusmapper joinusmapper) {
        this.joinusmapper = joinusmapper;
    }

    @PostMapping("/{id}")
    public int SignUp(@PathVariable("id") String id, @RequestParam("password") String password)
    {
        if(!((id == null) || (password == null))) // 입력오류 ErrCode 1
        {if (joinusmapper.ExistsID(id)) // 존재하지 않는 ID ErrCode 2
            {if (password.equals(joinusmapper.LoginPassword(id)))// ID Password 불일치 ErrCode 3
                {
                    return 0;// 정상 로그인
                }
                else {return 3;}
            }
            else{return 2;}
        }
        else {return 1;}
    }

    @PostMapping("/findid/{name}")
    public String findid(@PathVariable("name") String name, @RequestParam("email") String email)
    {
        return joinusmapper.FindID(name,email);
    }
    @PostMapping("/findpassword/{id}")
    public String findpassword(@PathVariable("id") String id, @RequestParam("security") String security)
    {
        if (joinusmapper.FindPasswordcheck(id,security))
        {
            Random random = new Random();
            String temp = random.ints(97,123).
                    limit(10).
                    collect(StringBuilder::new, StringBuilder::appendCodePoint,StringBuilder::append).toString();
            joinusmapper.ChangePassword(id,temp);
            return joinusmapper.FindPassword(id,security);
        }
        else return "false";
    }

}
