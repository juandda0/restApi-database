package com.juannn.restApiPractice.repository;

import com.juannn.restApiPractice.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
