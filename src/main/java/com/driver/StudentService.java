package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    void addStudent(Student student){
        studentRepository.addStudent(student);
    }
    void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }
    void addStudentTeacherPair(String sname, String tname){
        studentRepository.addStudentTeacherPair(sname,tname);
    }
    Student getStudentByName(String name){
        return studentRepository.getStudentByName(name);
    }
    Teacher getTeacherByName(String name){
        return studentRepository.getTeacherByName(name);
    }
    List<String> getStudentsByTeacherName(String name){
        return studentRepository.getStudentsByTeacherName(name);
    }
    List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }
    void deleteTeacherByName(String tname){
        studentRepository.deleteTeacherByName(tname);
    }
    void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }
}
