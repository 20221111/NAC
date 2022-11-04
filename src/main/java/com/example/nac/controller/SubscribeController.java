package com.example.nac.controller;

import com.example.nac.Mapper.Joinusmapper;
import com.example.nac.Mapper.SubscribeMapper;
import com.example.nac.model.SUBSCRIBE;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping(value = "/subscribe")
public class SubscribeController {
    private SubscribeMapper subscribeMapper;
    private Joinusmapper joinusmapper;

    Map<String,Object> err = new HashMap<>();

    public SubscribeController(SubscribeMapper subscribeMapper, Joinusmapper joinusmapper) {
        this.subscribeMapper = subscribeMapper;
        this.joinusmapper = joinusmapper;
    }

    @PostMapping("push/{type}")
    public Map<String,Object> push(@PathVariable("type") String type,
                                   @RequestParam("id") String id,
                                   @RequestParam("date") String date,
                                   @RequestParam("title") String title)
    {
        Map<String,Object> temp = new HashMap<>();
        if (joinusmapper.ExistsID(id))
        {
            subscribeMapper.PushSubscribe(type,id,date,title);
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
        if (subscribeMapper.PopSubscribe(num)) {
            temp.put("0", "입력성공");
            return temp;
        }
        temp.put("err","존재하지 않는 ID");
        return temp;
    }

    @PostMapping("Show/{id}")
    public List<SUBSCRIBE> Show(@PathVariable("id") String id) {
        return subscribeMapper.showSubscribe(id);
    }

}
