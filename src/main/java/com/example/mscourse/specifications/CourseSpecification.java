package com.example.mscourse.specifications;


import com.example.mscourse.entity.CourseEntity;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import org.springframework.data.jpa.domain.Specification;


public class CourseSpecification {
    public static Specification<CourseEntity> titleContains(String title) {
        return (root, query, cb) -> cb.like(root.get("title"), "%" + title + "%");
    }

    public static Specification<CourseEntity> hasLanguage(Integer languageId) {

        return (root, query, cb) -> cb.equal(root.get("languageId").get("languageId"), languageId);

    }

    public static Specification<CourseEntity> hasCategory(Integer categoryId) {
        return (root, query, cb) -> cb.equal(root.get("subCategoryId").get("categoryId").get("categoryId"), categoryId);

    }

    public static Specification<CourseEntity> hasLevel(Integer levelId) {
        return (root, query, cb) -> cb.equal(root.get("levelId").get("levelId"), levelId);
    }

    /*public static Specification<CourseEntity> orderByTitle() {
        return (root, query, cb) -> {
            query.orderBy(cb.asc(root.get("TITLE")));
            return cb.conjunction();
        };
    }*/
}
