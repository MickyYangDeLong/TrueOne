package service;

import db.StudentDao;
import dto.Student;

import java.util.List;
import java.util.Objects;

public class StudentServiceImp implements StudentService {
    public Student query(String name){
        Objects.requireNonNull(name);
        List<Student> studentList =  new StudentDao<String>().query(name);
        if (Objects.isNull(studentList) || studentList.isEmpty()){
            return  null;
        }
        return studentList.get(0);
    }
}
