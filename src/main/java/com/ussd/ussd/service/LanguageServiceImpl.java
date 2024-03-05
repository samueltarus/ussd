package com.ussd.ussd.service;

import com.ussd.ussd.model.Language;
import com.ussd.ussd.repository.LanguageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;
    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> list() {
        return  languageRepository.findAll();
    }

    @Override
    public Language save(Language language) {
        return languageRepository.save(language);
    }
}
