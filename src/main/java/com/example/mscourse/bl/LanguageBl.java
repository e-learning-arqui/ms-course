package com.example.mscourse.bl;

import com.example.mscourse.dao.LanguageRepository;
import com.example.mscourse.dto.LanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageBl {

    @Autowired
    private LanguageRepository languageRepository;

    public List<LanguageDto> getAllLanguages() {
        return this.languageRepository.findAll().stream().map(
                languageEntity -> new LanguageDto(
                        languageEntity.getLanguageId(),
                        languageEntity.getName()
                )
        ).toList(
        );
    }


}
