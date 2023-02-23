package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String , Student> studentrecord = new HashMap<>();
    HashMap<String , Teacher> teacherrecord = new HashMap<>();
    HashMap<Teacher , List<Student>> pair = new HashMap<>();
    void addStudent(Student student){
        studentrecord.put(student.getName(),student);
    }
    void addTeacher(Teacher teacher){
        teacherrecord.put(teacher.getName(),teacher);
    }
    void addStudentTeacherPair(String sname, String tname){
        Teacher teacher = teacherrecord.get(tname);
        if(pair.containsKey(teacher)){
            List<Student> list= pair.get(teacher);
            pair.remove(teacher);
            Student student = studentrecord.get(sname);
            list.add(student);
            pair.put(teacher,list);
        }
        else{
            List<Student> list = new ArrayList<>();
            Student student = studentrecord.get(sname);
            list.add(student);
            pair.put(teacher,list);
        }
    }
    Student getStudentByName(String name){
        return studentrecord.get(name);
    }
    Teacher getTeacherByName(String name){
        return teacherrecord.get(name);
    }
    List<String> getStudentsByTeacherName(String tname){
        Teacher teacher = teacherrecord.get(tname);
        List<String> list = new ArrayList<>();
        List<Student> student = pair.get(teacher);
        for(Student x : student){
            list.add(x.getName());
        }
        return list;
    }
    List<String> getAllStudents(){
        List<String> list = new ArrayList<>();
        for(String sname : studentrecord.keySet()){
            list.add(studentrecord.get(sname).getName());
        }
        return list;

    }
    void deleteTeacherByName(String tname){
        Teacher teacher = teacherrecord.get(tname);
        teacherrecord.remove(tname);
        pair.remove(teacher);

    }

    void deleteAllTeachers(){
        studentrecord.clear();
        teacherrecord.clear();
    }


}
