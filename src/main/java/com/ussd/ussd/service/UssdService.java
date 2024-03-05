package com.ussd.ussd.service;


import com.ussd.ussd.model.Ussd;
import java.util.List;

public interface UssdService  {

    List<Ussd> list(String ussdStep);
   Ussd findByName(String name);
}
