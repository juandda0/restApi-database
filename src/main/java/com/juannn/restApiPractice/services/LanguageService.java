package com.juannn.restApiPractice.services;

import com.juannn.restApiPractice.exceptions.ResourceNotFoundException;
import com.juannn.restApiPractice.models.Language;
import com.juannn.restApiPractice.repository.LanguageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {

    private static final Logger logger = LoggerFactory.getLogger(LanguageService.class);

    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> getAllLanguages() {
        logger.debug("Fetching all languages");
        return languageRepository.findAll();
    }

    public String saveLanguage(Language language) {
        logger.debug("Saving language: {}", language);
        languageRepository.save(language);
        return "Language stored, ID: " + language.getId();
    }

    public Language updateLanguage(Language language) {
        logger.debug("Updating language: {}", language);

        Optional<Language> existingLanguage = languageRepository.findById(language.getId());

        if (existingLanguage.isPresent()) {
            Language updatedLanguage = existingLanguage.get();
            updatedLanguage.setName(language.getName());
            updatedLanguage.setReleaseDate(language.getReleaseDate());
            updatedLanguage.setStrongTyped(language.isStrongTyped());

            return languageRepository.save(updatedLanguage);
        } else {
            logger.error("Language not found with id: {}", language.getId());
            throw new ResourceNotFoundException("Language not found with id: " + language.getId());
        }
    }

    public void deleteLanguage(int id) {
        logger.debug("Deleting language with id: {}", id);

        if (!languageRepository.existsById(id)) {
            logger.error("Language not found with id: {}", id);
            throw new ResourceNotFoundException("Language not found with id: " + id);
        }
        languageRepository.deleteById(id);
    }
}
