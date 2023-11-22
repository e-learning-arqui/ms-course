package com.example.mscourse.bl;

import com.example.mscourse.dao.CourseRepository;
import com.example.mscourse.dao.SectionRepository;
import com.example.mscourse.dto.SectionDto;
import com.example.mscourse.entity.CourseEntity;
import com.example.mscourse.entity.SectionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    //obtener las secciones por id
    public List<SectionDto> getSectionsByCourseId(Long courseId){
        List<SectionEntity> sectionEntityList = sectionRepository.findByCourseId(courseId);
        List<SectionDto> sectionDtoList = new ArrayList<>();
        for (SectionEntity sectionEntity : sectionEntityList) {
            SectionDto sectionDto = new SectionDto();
            sectionDto.setSectionId(sectionEntity.getSectionId());
            sectionDto.setCourseId(sectionEntity.getCourseId().getCourseId());
            sectionDto.setTitle(sectionEntity.getTitle());
            sectionDto.setDescription(sectionEntity.getDescription());
            sectionDto.setStatus(sectionEntity.getStatus());
            sectionDtoList.add(sectionDto);
        }
        return sectionDtoList;
    }

}
