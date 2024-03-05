package com.ussd.ussd.service;


import com.ussd.ussd.model.Ussd;
import com.ussd.ussd.repository.UssdRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UssdServiceImpl implements UssdService{

    private final UssdRepository ussdRepository;
    @Override
    public List<Ussd> list(String ussdStep) {
       return  ussdRepository.findAll();
    }
    @Override
    public Ussd findByName(String name) {
        System.out.println("ussd  Step name = " + name);
         Optional<Ussd> ussd= ussdRepository.findByName(name.toLowerCase().trim());
         if(ussd.isPresent()){
             System.out.println("name = " + ussd.get().getName());
             return ussd.get();
         }
        return new Ussd();
    }
}
