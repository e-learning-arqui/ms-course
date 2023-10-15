package com.example.mscourse.api;

import com.example.mscourse.bl.LevelBl;
import com.example.mscourse.dto.LevelDto;
import com.example.mscourse.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses/level")
public class LevelApi {
    @Autowired
    private LevelBl levelBl;


    @GetMapping("/all")
    public ResponseDto<List<LevelDto>> getAllLevels() {
        return new ResponseDto<>(
                "0000",
                levelBl.getAllLevels(),
                null
        );
    }
}
