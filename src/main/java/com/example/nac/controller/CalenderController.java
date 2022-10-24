package com.example.nac.controller;

import com.example.nac.Mapper.bonschamapper;
import com.example.nac.Mapper.commschemapper;
import com.example.nac.model.Scadule;
import com.example.nac.model.bonsche;
import com.example.nac.model.commsche;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/calender")
public class CalenderController {
    //달력 정보를 넘겨주는 달력 컨트롤러

    private ArrayList<Scadule> scadules;
    private bonschamapper bonmapper;
    private commschemapper commapper;

    public CalenderController(bonschamapper bonmapper, commschemapper commapper) {
        this.bonmapper = bonmapper;
        this.commapper = commapper;
    }


    //날자를 알려주면 해당 날자의 본회의 일정을 돌려줌
    @GetMapping("/date/{date}")
    public List<bonsche> GetCalenderDate(@PathVariable("date") String date){
        return bonmapper.GetbonscheDate(date);
    }

    //날자를 알려주면 해당 한달간의 본회의 일정을 돌려줌
    @GetMapping("/month/{date}")
    public List<Scadule> GetcommscheDate(@PathVariable("date") String date){
        String month = date.substring(0, 7); //년도와 달로 자름 2022-09-28 -> 2022-09
        scadules.addAll(bonmapper.GetbonscheMonth(month));
        scadules.addAll(commapper.GetcommscheMonth(month));
        return scadules;
    }

    /*@PutMapping("commsche/put/{TITLE}")
    public void putcommsche(@PathVariable("TITLE")String TITLE, @RequestParam("meetingsession") String meetingsession, @RequestParam("cha") String cha, @RequestParam("meeting_date") String meeting_time, @RequestParam("meeting_time") String meeting_date,@RequestParam("link_url") String link_url, @RequestParam("unit_cd") String unit_cd, @RequestParam("unit_nm") String unit_nm){
        mapper.Putcommsche(meetingsession, cha, TITLE, meeting_date, meeting_time, link_url, unit_cd, unit_nm);
    }*/

}
