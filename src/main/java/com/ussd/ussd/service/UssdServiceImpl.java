package com.ussd.ussd.service;


import com.ussd.ussd.model.Ussd;
import com.ussd.ussd.repository.UssdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UssdServiceImpl implements UssdService{
    @Autowired
    private UssdRepository ussdRepository;

    @Override
    public Ussd list(String ussdStep) {
       return (Ussd) ussdRepository.findAll();
    }
}
