package com.example.mscourse.bl;

import com.example.mscourse.dao.CourseRepository;
import com.example.mscourse.dao.SectionRepository;
import com.example.mscourse.dto.SectionDto;
import com.example.mscourse.entity.CourseEntity;
import com.example.mscourse.entity.SectionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionBl {

    @Autowired
    private  SectionRepository sectionRepository;

    @Autowired
    private CourseRepository courseRepository;

    public void saveSection(SectionDto sectionDto){
        CourseEntity course = courseRepository.findById(sectionDto.getCourseId()).get();

        SectionEntity sectionEntity = new SectionEntity();
        sectionEntity.setTitle(sectionDto.getTitle());
        sectionEntity.setDescription(sectionDto.getDescription());
        sectionEntity.setCourseId(course);
        sectionEntity.setStatus(true);
        sectionRepository.save(sectionEntity);


    }

}
