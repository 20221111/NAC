package com.example.nac.controller;

import com.example.nac.Mapper.Joinusmapper;
import com.example.nac.Mapper.Memomapper;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/Memo")
public class MemoController {
    private Memomapper memomapper;
    private Joinusmapper joinusmapper;

    Map<String,Object> err = new HashMap<>();

    public MemoController(Memomapper memomapper, Joinusmapper joinusmapper) {
        this.memomapper = memomapper;
        this.joinusmapper = joinusmapper;
    }

    @PostMapping("push/{id}")
    public Map<String,Object> push(@PathVariable("id") String id,
                                   @RequestParam("Contents") String Contents,
                                   @RequestParam("date") String date)
    {
        Map<String,Object> temp = new HashMap<>();
        if (joinusmapper.ExistsID(id))
        {
            memomapper.PushMemo(id,Contents,date);
            temp.put("0","입력성공");
            return temp;
        }
        temp.put("err","존재하지 않는 ID");
        return temp;
    }

    @PostMapping("pop/{num}")
    public Map<String,Object> pop(@PathVariable("num") String num)
    {
        Map<String, Object> temp = new HashMap<>();
        if (memomapper.PopMemo(num)) {
            temp.put("0", "삭제성공");
            return temp;
        }
        temp.put("err","존재하지 않는 ID");
        return temp;
    }

    @PostMapping("Show/{id}")
    public Map<String,Object> Show(@PathVariable("id") String id) {
        Map<String, Object> temp = new HashMap<>();
        temp.put("MEMO", memomapper.GetMemo(id));
        return temp;
    }

    @PostMapping("Show/date/{id}")
    public Map<String,Object> Show(@PathVariable("id") String id,@RequestParam("date") String date) {
        Map<String, Object> temp = new HashMap<>();
        temp.put("MEMO", memomapper.GetMemoDate(date,id));
        return temp;
    }

}
