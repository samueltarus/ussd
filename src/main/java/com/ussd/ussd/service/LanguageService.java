package com.ussd.ussd.service;

import com.ussd.ussd.model.Language;
import java.util.List;

public interface LanguageService {
     List<Language> list();
     Language save(Language language);
}
