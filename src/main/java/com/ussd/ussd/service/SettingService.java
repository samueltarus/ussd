package com.ussd.ussd.service;


import com.ussd.ussd.model.Setting;

public interface SettingService {
   Setting list();

    Setting save(Setting setting);
}
