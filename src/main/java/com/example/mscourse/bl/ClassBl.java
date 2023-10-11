package com.example.mscourse.bl;

import com.example.mscourse.dao.ClassRepository;
import com.example.mscourse.dao.SectionRepository;
import com.example.mscourse.dto.ClassDto;
import com.example.mscourse.entity.ClassEntity;
import com.example.mscourse.entity.SectionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Logger;

@Service
public class ClassBl {

    @Autowired
    private final ClassRepository classRepository;

    @Autowired
    private final SectionRepository sectionRepository;


    Logger log = Logger.getLogger(ClassBl.class.getName());
    public ClassBl(ClassRepository classRepository
    , SectionRepository sectionRepository) {
        this.classRepository = classRepository;
        this.sectionRepository = sectionRepository;
    }

    public void saveClass(ClassDto classDto, Long sectionId) {
        log.info("Saving class: " + classDto.getTitle() + " in database");
        SectionEntity section = sectionRepository.findById(sectionId).get();
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
        ClassEntity classEntity = new ClassEntity();
        classEntity.setTitle(classDto.getTitle());
        classEntity.setDescription(classDto.getDescription());
        classEntity.setSectionId(section);
        classEntity.setDuration(classDto.getDuration());
        classEntity.setStartDate(date);
        classRepository.save(classEntity);
    }

    public Page<ClassDto> getClassesByCourseId(Long courseId, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ClassEntity> classEntities = classRepository.getClassesByCourseId(courseId, pageable);
        return classEntities.map(this::convertToDto);
    }

    private ClassDto convertToDto(ClassEntity classEntity) {
        ClassDto classDto = new ClassDto();
        classDto.setClassId(classEntity.getClassId());
        classDto.setTitle(classEntity.getTitle());
        classDto.setDescription(classEntity.getDescription());
        classDto.setDuration(classEntity.getDuration());
        classDto.setStartDate(classEntity.getStartDate());
        classDto.setSectionId(classEntity.getSectionId().getSectionId());
        return classDto;
    }


}
