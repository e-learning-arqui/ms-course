package com.example.mscourse.bl;

import com.example.mscourse.dao.CourseRepository;
import com.example.mscourse.dao.SectionRepository;
import com.example.mscourse.dto.SectionDto;
import com.example.mscourse.entity.CourseEntity;
import com.example.mscourse.entity.SectionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionBl {

    @Autowired
    private  SectionRepository sectionRepository;

    @Autowired
    private CourseRepository courseRepository;

    public void saveSection(SectionDto sectionDto, Long id){
        CourseEntity course = courseRepository.findById(id).orElse(null);
        SectionEntity sectionEntity = new SectionEntity();
        sectionEntity.setTitle(sectionDto.getTitle());
        sectionEntity.setDescription(sectionDto.getDescription());
        sectionEntity.setCourseId(course);
        sectionEntity.setStatus(true);
        sectionRepository.save(sectionEntity);


    }

    public List<SectionDto> getSectionsByCourseId(Long id){
        List<SectionEntity> sectionEntities = sectionRepository.findByCourseId(id);
        if(sectionEntities.isEmpty()){
            return null;
        }
        return sectionEntities.stream().map(this::toSectionDto).toList();
    }

    public List<SectionDto> findAllSections(){
        List<SectionEntity> sectionEntities = sectionRepository.findAll();
        if(sectionEntities.isEmpty()){
            return null;
        }
        return sectionEntities.stream().map(this::toSectionDto).toList();
    }

    SectionDto toSectionDto(SectionEntity sectionEntity){
        SectionDto sectionDto = new SectionDto();
        sectionDto.setSectionId(sectionEntity.getSectionId());
        sectionDto.setTitle(sectionEntity.getTitle());
        sectionDto.setDescription(sectionEntity.getDescription());
        sectionDto.setStatus(sectionEntity.getStatus());
        sectionDto.setCourseId(sectionEntity.getCourseId().getCourseId());
        return sectionDto;
    }

    public void deleteSection(Long id){
        SectionEntity sectionEntity = sectionRepository.findById(id).orElse(null);
        sectionEntity.setStatus(false);
        sectionRepository.save(sectionEntity);
    }
}
