package com.ussd.ussd.service;


import com.ussd.ussd.model.Setting;

public interface SettingService {
  public Setting list();

   public Setting save(Setting setting);
}
