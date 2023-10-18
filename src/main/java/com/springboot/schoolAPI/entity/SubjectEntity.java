package com.springboot.schoolAPI.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "SUBJECT")
@NoArgsConstructor
@Setter
@Getter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SUBJECT_CODE")
    private String subjectCode;

    @Column(name = "DETAIL")
    private String detail;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "SUBJECT_STUDENT_MAPPING",
            joinColumns = @JoinColumn(name = "SUBJECT_ID"),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID")
    )
    private Set<StudentEntity> StudentMapping = new HashSet<>();

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
//    private TeacherEntity teacher;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "SUBJECT_TEACHER_MAPPING",
            joinColumns = @JoinColumn(name = "SUBJECT_ID"),
            inverseJoinColumns = @JoinColumn(name = "TEACHER_ID")
    )
    private Set<TeacherEntity> teacherMapping = new HashSet<>();

    public void enrollStudent(StudentEntity student) {
        StudentMapping.add(student);
    }

    public void assignTeacher(TeacherEntity teacher) {
        teacherMapping.add(teacher);
    }
}
