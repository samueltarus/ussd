package com.ussd.ussd.utility;


import com.ussd.ussd.model.Setting;
import com.ussd.ussd.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentHelper {
    @Autowired
    private SettingService settingService;

    public String initiatePayment(String phoneNumber,Double amount){
        Setting setting= settingService.list();
        //get member


        return "";

    }
}
