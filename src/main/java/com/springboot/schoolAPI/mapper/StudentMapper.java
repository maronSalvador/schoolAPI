package com.springboot.schoolAPI.mapper;

import com.springboot.schoolAPI.dto.Student;
import com.springboot.schoolAPI.entity.StudentEntity;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentEntity update(Student student, @MappingTarget StudentEntity entity);

}
