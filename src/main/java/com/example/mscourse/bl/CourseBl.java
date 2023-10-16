package com.example.mscourse.bl;
import com.example.mscourse.dao.ProfessorRepository;
import com.example.mscourse.dto.CourseDto;
import com.example.mscourse.entity.*;
import com.example.mscourse.service.FileService;
import com.example.mscourse.specifications.CourseSpecification;
import jakarta.ws.rs.core.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.mscourse.dao.CourseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CourseBl {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private FileService fileService;
    private final Logger log = LoggerFactory.getLogger(CourseBl.class);



    public Long saveCourse(CourseDto courseDto){

        log.info("Saving course");
        log.info("Finding professor by professorId: " + courseDto.getProfessorKeycloakId());
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
        log.info("Saving course with title: " + courseEntity.getTitle() + " and professorId: " + courseDto.getProfessorKeycloakId());

        courseRepository.saveAndFlush(courseEntity);
        Long courseId = courseEntity.getCourseId();
        return courseId;
    }


    public Page<CourseDto> findAllCourses(Pageable pageable, String title,  Integer languageId, Integer categoryId, Integer levelId){
        log.info("Finding all courses");
        Specification<CourseEntity> spec = Specification.where(null);
        if (title != null) {
            spec = spec.and(CourseSpecification.titleContains(title));
        }
        if (languageId != null) {
            spec = spec.and(CourseSpecification.hasLanguage(languageId));
        }
        if (categoryId != null) {
            spec = spec.and(CourseSpecification.hasCategory(categoryId));
        }
        if (levelId != null) {
            spec = spec.and(CourseSpecification.hasLevel(levelId));
        }
        //spec = spec.and(CourseSpecification.orderByTitle());

        Page<CourseEntity> courseEntityPage = courseRepository.findAll(spec,pageable);
        return courseEntityPage.map(this::convertToCourseDto);
    }

    public Page<CourseDto> coursesByProfessorId(String professorId, Pageable pageable){
        log.info("Finding courses by professorId: " + professorId);
        log.info("Finding professor by professorId: " + professorId);
        ProfessorEntity professorEntity = professorRepository.getProfessorByProfessorKeycloakId(professorId);
        Page<CourseEntity> courseEntityPage = courseRepository.findByProfessorId(professorEntity.getProfessorId(), pageable);
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
        System.out.println("URL: " + url(courseEntity.getTitle()));
        courseDto.setLogoUrl(url(courseEntity.getTitle()));
        return courseDto;
    }

    private String url(String courseName){
        return this.fileService.getUrlLogo(courseName).getBody().toString();
    }


}
