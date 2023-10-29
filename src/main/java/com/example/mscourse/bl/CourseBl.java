package com.example.mscourse.bl;
import com.example.mscourse.dao.ProfessorRepository;
import com.example.mscourse.dao.SubCategoryRepository;
import com.example.mscourse.dto.CourseDto;
import com.example.mscourse.dto.builder.CourseDtoBuilder;
import com.example.mscourse.entity.*;
import com.example.mscourse.service.FileService;
import com.example.mscourse.service.KeycloakService;
import com.example.mscourse.specifications.CourseSpecification;
import jakarta.ws.rs.core.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.mscourse.dao.CourseRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CourseBl {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private FileService fileService;

    @Autowired
    private SubCategoryBl subCategoryBl;

    @Autowired
    private KeycloakService keycloakService;

    @Value("${keycloak.credentials.secret}")
    private String clientSecret;

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


        SubCategoryEntity subCategoryEntity = subCategoryRepository.findBySubCategoryName(courseDto.getSubCategoryName());


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


    public Page<CourseDtoBuilder> findAllCourses(Pageable pageable,
                                                 String title,  Integer languageId,
                                                 Integer categoryId,
                                                 Integer levelId,
                                                 Boolean url){
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

        return courseEntityPage.map(courseEntity -> this.convertToCourseDto(courseEntity, url));
    }

    public Page<CourseDto> coursesByProfessorId(String professorId, Pageable pageable){
        log.info("Finding courses by professorId: " + professorId);
        ProfessorEntity professorEntity = professorRepository.getProfessorByProfessorKeycloakId(professorId);
        Page<CourseEntity> courseEntityPage = courseRepository.findByProfessorId(professorEntity.getProfessorId(), pageable);
        return null;
    }

    public CourseDtoBuilder findById(Long courseId){
        log.info("Finding course by id: " + courseId);
        CourseEntity courseEntity = courseRepository.findByCourseId(courseId);
        return this.convertToCourseDto(courseEntity, false);
    }


    private CourseDtoBuilder convertToCourseDto(CourseEntity courseEntity, Boolean url) {
        String subCategoryName = subCategoryBl.findSubCategoryNameById(courseEntity.getSubCategoryId().getId());

        CourseDtoBuilder.Builder builder = new CourseDtoBuilder.Builder()
                .withTitle(courseEntity.getTitle())
                .withDescription(courseEntity.getDescription())
                .withAmount(courseEntity.getAmount())
                .withVersion(courseEntity.getVersion())
                .withDuration(courseEntity.getDuration())
                .withLanguageId(courseEntity.getLanguageId().getId())
                .withLevelId(courseEntity.getLevelId().getId())
                .withSubCategoryName(subCategoryName)
                .withProfessorKeycloakId(courseEntity.getProfessorId().getKeycloakId());

        if (Boolean.TRUE.equals(url)) {
            builder.withLogoUrl(url(courseEntity.getTitle()));
        }

        return builder.build();
    }

    private String url(String courseName){


        return this.fileService.getUrlLogo(
                courseName).getBody();
    }


}
