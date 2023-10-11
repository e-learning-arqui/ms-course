package com.example.mscourse.dao;

import com.example.mscourse.entity.SubCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity,Long> {

    /*
    @Query(value = "SELECT sc FROM SubCategoryEntity sc WHERE sc.category.categoryId = :idCategory" )
    List<SubCategoryEntity> findAllSubCategoriesByCategoryId(@Param("idCategory") Long idCategory);
*/
    @Query(value = "SELECT sc FROM SubCategoryEntity sc WHERE sc.categoryId.categoryId = :idCategory" )
    List<SubCategoryEntity> findAllSubCategoriesByCategoryId(@Param("idCategory") Long idCategory);
}

