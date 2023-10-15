package com.example.mscourse.api;

import com.example.mscourse.bl.LanguageBl;
import com.example.mscourse.dto.LanguageDto;
import com.example.mscourse.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses/language")
public class LanguageApi {

    @Autowired
    private LanguageBl languageBl;

    @GetMapping("/all")
    public ResponseDto<List<LanguageDto>> getAllLanguages() {
        return new ResponseDto<>(
                "0000",
                languageBl.getAllLanguages(),
                null
        );
    }
}
