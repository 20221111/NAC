package com.example.nac.controller;

import com.example.nac.Mapper.Joinusmapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Acoount")
public class AccountController {
    private Joinusmapper joinusmapper;

    public AccountController(Joinusmapper joinusmapper) {
        this.joinusmapper = joinusmapper;
    }

    @PostMapping("/changepassword/{id}")
    public int changepassword(@PathVariable("id") String id, @RequestParam("curpassword") String curpassword ,@RequestParam("password") String password)
    {
        if (curpassword.equals(joinusmapper.LoginPassword(id)))
        {
            joinusmapper.ChangePassword(id,password);
            return 0;
        }
        return 1;
    }

    @PostMapping("/changeid/{curid}")
    public int changeid(@PathVariable("curid") String curid, @RequestParam("id") String id, @RequestParam("password") String password)
    {
        if (password.equals(joinusmapper.LoginPassword(curid)))
        {
            joinusmapper.ChangeId(id,curid);
            return 0;
        }
        return 1;
    }

    @PostMapping("/changeAccount/{curid}")
    public int changeAccount(@PathVariable("curid") String curid, @RequestParam("curpassword") String curpassword,
                             @RequestParam("id") String id, @RequestParam("email") String email,
                             @RequestParam("password") String password, @RequestParam("name") String name,
                             @RequestParam("security") String security)
    {
        if((id == null) || (email == null) || (password == null) || (name == null) || (security == null))
        {
            return 1;
        }
        else
        {
            if (curpassword.equals(joinusmapper.LoginPassword(curid))) {
                joinusmapper.changeAccount(curid,id, email, password, name, security);
                return 0;
            }
            return 1;
        }
    }

}
