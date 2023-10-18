package com.springboot.schoolAPI.repository;

import com.springboot.schoolAPI.entity.ClassSectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClassSectionRepository extends JpaRepository<ClassSectionEntity, Long> {
    @Query(value = "SELECT * FROM schoolapi.CLASS_SECTION CS WHERE CS.SECTION_NAME = ?1", nativeQuery = true)
    Optional<ClassSectionEntity> findByName(String name);
}
