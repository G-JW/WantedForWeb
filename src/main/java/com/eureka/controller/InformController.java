package com.eureka.controller;

import com.eureka.domain.Inform;
import com.eureka.service.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inform")
public class InformController {
    @Autowired
    private InformService informService;

    @GetMapping("/{type}")
    public Object getByType(@PathVariable String type){
        return informService.getByType(type);
    }

    @PostMapping
    public String save(@RequestBody Inform inform){
        boolean save = informService.save(inform);
        if(save) {
            return "success";
        }else{
            return "fail";
        }
    }
}
