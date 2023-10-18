package com.springboot.schoolAPI.repository;

import com.springboot.schoolAPI.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    @Query(value = "SELECT * FROM schoolapi.STUDENT S WHERE S.STUDENT_NUMBER = ?1", nativeQuery = true)
    Optional<StudentEntity> findByStudentNumber(String studentNumber);
}
