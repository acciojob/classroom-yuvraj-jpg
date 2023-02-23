package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class StudentRepository {
    private HashMap<String , Student> studentrecord ;
    private HashMap<String , Teacher> teacherrecord ;
    private HashMap<String , List<String>> pair;

    public StudentRepository() {
        this.studentrecord=new HashMap<>();
        this.teacherrecord=new HashMap<>();
        this.pair = new HashMap<>();
    }

    public void addStudent(Student student){
        studentrecord.put(student.getName(),student);
    }
    public void addTeacher(Teacher teacher){
        teacherrecord.put(teacher.getName(),teacher);
    }
    public void addStudentTeacherPair(String sname, String tname){
        if(studentrecord.containsKey(sname) && teacherrecord.containsKey(tname)){
            studentrecord.put(sname,studentrecord.get(sname));
            teacherrecord.put(tname,teacherrecord.get(tname));
            List<String> list = new ArrayList<>();
            if(pair.containsKey(tname)){
                list=pair.get(tname);
            }
            list.add(sname);
            pair.put(tname,list);
        }
    }
    public Student getStudentByName(String name){
        return studentrecord.get(name);
    }
    public Teacher getTeacherByName(String name){
        return teacherrecord.get(name);
    }
    public List<String> getStudentsByTeacherName(String tname){
        List<String> list = new ArrayList<>();
        if(pair.containsKey(tname)){
            list=pair.get(tname);
        }
        return list;

    }
    public List<String> getAllStudents(){
        return new ArrayList<>(studentrecord.keySet());

    }
    public void deleteTeacherByName(String tname){
        List<String> list =new ArrayList<>();
        if(pair.containsKey(tname)){
            list= pair.get(tname);
            for(String name : list){
                if(studentrecord.containsKey(name)){
                    studentrecord.remove(name);
                }
            }
            pair.remove(tname);
        }
        if(pair.containsKey(tname)){
            teacherrecord.remove(tname);
        }

    }

    public void deleteAllTeachers(){
        HashSet<String> set = new HashSet<>();
        for(String tname:pair.keySet()){
            for(String sname : pair.get(tname)){
                set.add(sname);
            }
        }
        for(String sname:set){
            if(studentrecord.containsKey(sname)){
                studentrecord.remove(sname);
            }
        }
    }


}
