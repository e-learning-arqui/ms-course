package com.example.mscourse.bl;

import com.example.mscourse.dao.LevelRepository;
import com.example.mscourse.dto.LevelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelBl {

    @Autowired
    private LevelRepository levelRepository;

    public List<LevelDto> getAllLevels() {
        return this.levelRepository.findAll().stream().map(
                levelEntity -> new LevelDto(
                        levelEntity.getLevelId(),
                        levelEntity.getLevelName()
                )
        ).toList(
        );
    }
}
