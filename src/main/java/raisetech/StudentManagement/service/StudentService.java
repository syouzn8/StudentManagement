package raisetech.StudentManagement.service;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.util.EnglishEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;


  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList() {
    return repository.search().stream()
        .filter(student -> student.getAge() >= 30)
        .collect(Collectors.toList());
  }


  public List<StudentsCourses> searchStudentsCourseList() {
    return repository.searchStudentsCourses().stream()
        .filter(as -> "JAVAコース".equals(as.getCoursName()))
        .collect(Collectors.toList());
  }

}

}




}


