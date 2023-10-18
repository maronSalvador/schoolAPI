package com.springboot.schoolAPI.service;


import com.springboot.schoolAPI.dto.Teacher;
import com.springboot.schoolAPI.entity.TeacherEntity;
import com.springboot.schoolAPI.exceptions.ResourceNotFoundException;
import com.springboot.schoolAPI.mapper.TeacherMapper;
import com.springboot.schoolAPI.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.springboot.schoolAPI.model.Constants.TEACHER_CODE;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<TeacherEntity> getAllTeacher() {
        return teacherRepository.findAll();
    }

    public TeacherEntity getTeacherById(Long id) {
        return teacherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    public TeacherEntity createTeacher(TeacherEntity teacher) {
        teacher.setTeacherNumber(EntityNumberGenerator.entityNumberGenerator(TEACHER_CODE));
        return teacherRepository.save(teacher);
    }

    public TeacherEntity updateTeacher(Teacher teacher, Long id) {
        TeacherEntity existingTeacher = getTeacherById(id);
        TeacherEntity updatedEntity = TeacherMapper.INSTANCE.update(teacher, existingTeacher);
        return teacherRepository.save(updatedEntity);
    }

    public void deleteTeacher(Long id) {
        TeacherEntity existingTeacher = getTeacherById(id);
        teacherRepository.delete(existingTeacher);
    }

}


