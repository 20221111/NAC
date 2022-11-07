package com.example.nac.controller;

import com.example.nac.Mapper.Joinusmapper;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
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
        {
            if (joinusmapper.ExistsID(id)) // 존재하지 않는 ID 또는 ID Password 불일치 ErrCode 2
            {
                if (password.equals(joinusmapper.LoginPassword(id)))
                {return 0;}// 정상 로그인
                else{return 2;}
            }
            else{return 2;}
        }
        else {return 1;}
    }

    @PostMapping("/findid/{name}")
    public Map<String,Object> findid(@PathVariable("name") String name, @RequestParam("email") String email)
    {
        Map<String,Object> map = new HashMap<>();
        map.put("id", joinusmapper.FindID(name,email));
        if (map.get("id") == null)
        {
            Map<String,Object> err = new HashMap<>();
            err.put("err","이름 또는 이메일 오류");
            return err;
        }
        return map;
    }
    @PostMapping("/findpassword/{id}")
    public Map<String,Object> findpassword(@PathVariable("id") String id, @RequestParam("security") String security)
    {
        if (joinusmapper.FindPasswordcheck(id,security))
        {
            Random random = new Random();
            String temp = random.ints(97,123).
                    limit(10).
                    collect(StringBuilder::new, StringBuilder::appendCodePoint,StringBuilder::append).toString();
            joinusmapper.ChangePassword(id,temp);

            Map<String,Object> map = new HashMap<>();
            map.put("id", joinusmapper.FindPassword(id,security));
            return map;
        }
        else
        {
            Map<String,Object> err = new HashMap<>();
            err.put("err","id 또는 보안질문 오류");
            return err;
        }

    }

}
