package com.example.nac.controller;

import com.example.nac.Mapper.bonschamapper;
import com.example.nac.model.bonsche;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class bonschecontroller {
    private bonschamapper mapper;

    public bonschecontroller(bonschamapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("bonsche/all")
    public List<bonsche> getbonscheList(){
        return mapper.GetBonscheList();
    }

        @GetMapping("bonsche/title/{TITLE}")
    public bonsche getbonschetitle(@PathVariable("TITLE") String TITLE){
        return mapper.GetBonscheTitle(TITLE);
    }

    @GetMapping("bonsche/date/{date}")
    public List<bonsche> getbonschedate(@PathVariable("date") String date){
        return mapper.GetBonscheDate(date);
    }

    @PutMapping("bonsche/put/{TITLE}")
    public void putbonsche(@PathVariable("TITLE")String TITLE, @RequestParam("meetingsession") String meetingsession, @RequestParam("cha") String cha, @RequestParam("meeting_date") String meeting_time, @RequestParam("meeting_time") String meeting_date,@RequestParam("link_url") String link_url, @RequestParam("unit_cd") String unit_cd, @RequestParam("unit_nm") String unit_nm){
        mapper.PutBonsche(meetingsession, cha, TITLE, meeting_date, meeting_time, link_url, unit_cd, unit_nm);
    }

}
