package com.ussd.ussd.service;

import com.ussd.ussd.model.Language;

public interface LanguageService {
     Language list();
     Language save();

     Language save(Language setting);
}
