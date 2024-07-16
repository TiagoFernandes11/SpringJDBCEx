package udemy.SpringJDBCEx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.SpringJDBCEx.model.Student;
import udemy.SpringJDBCEx.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public void addStudent(Student s){
        repository.save(s);
    }

    public List<Student> getStudents(){
        return repository.findAll();
    }
}
