package com.ussd.ussd.controller;

import com.ussd.ussd.model.Setting;
import com.ussd.ussd.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "settings")
public class SettingController {
    @Autowired
    private SettingService settingService;

    @GetMapping(value = "/list")
    public Setting list(){
        return settingService.list();
    }
    @PostMapping(value = "/save")
    public Setting save(@RequestBody Setting setting){

        return settingService.save(setting);
    }
}
