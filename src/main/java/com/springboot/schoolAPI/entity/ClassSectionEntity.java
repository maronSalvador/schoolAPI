package com.springboot.schoolAPI.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "CLASS_SECTION")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ClassSectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SECTION_NAME")
    private String sectionName;

    @Column(name = "NUMBER_OF_STUDENTS_ENROLLED")
    private int numberOfStudentsEnrolled;

    @OneToMany
    @JoinTable(name = "STUDENT_SECTION_MAPPING",
                joinColumns = @JoinColumn(name = "SECTION_ID"),
                inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
    private Set<StudentEntity> studentSubjectMapping = new HashSet<>();

    public void addStudentToSection(StudentEntity student) {
        studentSubjectMapping.add(student);
    }

}
