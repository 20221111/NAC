package com.example.nac.controller;

import com.example.nac.Mapper.testmapper;
import com.example.nac.model.test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class testcontroller {
    testmapper mapper;

    public testcontroller(testmapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping("test/{name}")
    public test gettest(@PathVariable("name") String name){
    return mapper.GettestID(name);
    }

    @GetMapping("test/all")
    public List<test> gettestall(){
        return mapper.Gettestall();
    }
}
