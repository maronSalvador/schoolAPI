package com.springboot.schoolAPI.mapper;

import com.springboot.schoolAPI.dto.Subject;
import com.springboot.schoolAPI.entity.SubjectEntity;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

public interface SubjectMapper {
    SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);

    SubjectEntity update(Subject subject, @MappingTarget SubjectEntity subjectEntity);

}
