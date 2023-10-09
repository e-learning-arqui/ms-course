package com.example.mscourse.bl;
import com.example.mscourse.dao.ProfessorRepository;
import com.example.mscourse.dto.CourseDto;
import com.example.mscourse.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.mscourse.dao.CourseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class CourseBl {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    private final Logger log = LoggerFactory.getLogger(CourseBl.class);

    public void saveCourse(CourseDto courseDto){
        log.info("Saving course");

        ProfessorEntity professor = professorRepository.getProfessorByProfessorKeycloakId(courseDto.getProfessorKeycloakId());
        log.info("Professor: " + professor.toString());
        CourseEntity courseEntity = new CourseEntity();
        LanguageEntity languageEntity = new LanguageEntity();
        languageEntity.setId(courseDto.getLanguageId());
        LevelEntity levelEntity = new LevelEntity();
        levelEntity.setId(courseDto.getLevelId());

        SubCategoryEntity subCategoryEntity = new SubCategoryEntity();
        subCategoryEntity.setId(courseDto.getSubCategoryId());


        courseEntity.setTitle(courseDto.getTitle());
        courseEntity.setStartDate(new Date());
        courseEntity.setStatus(true);
        courseEntity.setDescription(courseDto.getDescription());
        // HACER ALGUNA ESPECIE DE Procedimiento almacenado que actualice el lastUpdate
        courseEntity.setLastUpdate(new Date());
        courseEntity.setAmount(courseDto.getAmount());
        courseEntity.setVersion(courseDto.getVersion());
        courseEntity.setDuration(courseDto.getDuration());
        courseEntity.setLanguageId(languageEntity);
        courseEntity.setLevelId(levelEntity);
        courseEntity.setSubCategoryId(subCategoryEntity);
        courseEntity.setProfessorId(professor);
        log.info("Saving course with title: " + courseEntity.getTitle() + " and professorId: " + courseDto.getProfessorKeycloakId()
             );

        courseRepository.saveAndFlush(courseEntity);
    }


    public Page<CourseDto> findAllCourses(Pageable pageable){
        log.info("Finding all courses");
        Page<CourseEntity> courseEntityPage = courseRepository.findAllCourses(pageable);
        return courseEntityPage.map(this::convertToCourseDto);
    }

    public CourseDto findById(Long courseId){
        log.info("Finding course by id: " + courseId);
        CourseEntity courseEntity = courseRepository.findByCourseId(courseId);
        return convertToCourseDto(courseEntity);
    }

    private CourseDto convertToCourseDto(CourseEntity courseEntity){
        CourseDto courseDto = new CourseDto();
        courseDto.setTitle(courseEntity.getTitle());
        courseDto.setDescription(courseEntity.getDescription());
        courseDto.setAmount(courseEntity.getAmount());
        courseDto.setVersion(courseEntity.getVersion());
        courseDto.setDuration(courseEntity.getDuration());
        courseDto.setLanguageId(courseEntity.getLanguageId().getId());
        courseDto.setLevelId(courseEntity.getLevelId().getId());
        courseDto.setSubCategoryId(courseEntity.getSubCategoryId().getId());

        return courseDto;
    }


}
