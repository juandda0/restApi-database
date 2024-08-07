package com.juannn.restApiPractice.controllers;

import com.juannn.restApiPractice.models.Language;
import com.juannn.restApiPractice.services.LanguageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    private static final Logger logger = LoggerFactory.getLogger(LanguageController.class);

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/")
    public String helloSpring() {
        logger.debug("Handling GET request for /");
        return "Hello Spring";
    }

    @GetMapping
    public List<Language> getLanguages() {
        logger.debug("Handling GET request for /languages");
        return languageService.getAllLanguages();
    }

    @PostMapping
    public String createLanguage(@RequestBody Language language) {
        logger.debug("Handling POST request for /languages with body: {}", language);
        return languageService.saveLanguage(language);
    }

    @PutMapping
    public Language updateLanguage(@RequestBody Language language) {
        logger.debug("Handling PUT request for /languages with body: {}", language);
        return languageService.updateLanguage(language);
    }

    @DeleteMapping("/{id}")
    public String deleteLanguage(@PathVariable int id) {
        logger.debug("Handling DELETE request for /languages/{}", id);
        languageService.deleteLanguage(id);
        return "Language deleted, ID: " + id;
    }
}
