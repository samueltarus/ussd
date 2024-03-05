package com.ussd.ussd.service;

import com.ussd.ussd.model.Setting;
import com.ussd.ussd.repository.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingServiceImpl implements SettingService{
    private final SettingRepository settingRepository;
    @Autowired
    public SettingServiceImpl(SettingRepository settingRepository) {
        this.settingRepository = settingRepository;
    }

    @Override
    public Setting list() {
        return (Setting) settingRepository.findAll();
    }

    @Override
    public Setting save(Setting setting) {
        return settingRepository.save(setting);
    }
}
