package com.springboot.schoolAPI.mapper;

import com.springboot.schoolAPI.dto.Teacher;
import com.springboot.schoolAPI.entity.TeacherEntity;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

public interface TeacherMapper {

    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    TeacherEntity update(Teacher teacher, @MappingTarget TeacherEntity entity);
}
