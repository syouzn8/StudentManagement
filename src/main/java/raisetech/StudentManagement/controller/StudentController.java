package raisetech.StudentManagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import raisetech.StudentManagement.controller.converter.StudentConverter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

  private StudentService service;
  private StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  @GetMapping("/studentList")
  public String getStudentList(Model model) {
    List<Student> students = service.searchStudentList();
    List<StudentsCourses> studentsCourses = service.searchStudentsCourseList();

    model.addAttribute("studentList", converter.convertStudentDetails(students, studentsCourses));
    return "studentList";
  }

  @GetMapping("/studentsCourseList")
  public List<StudentsCourses> getStudentsCourseList() {
    return service.searchStudentsCourseList();
  }

  @GetMapping("/newStudent")
  public String newStudent(Model model) {
    model.addAttribute("studentDetail", new StudentDetail());
    return "registerStudent";
  }


  @PostMapping("/registerStudent")
  public String registerStudent(@ModelAttribute StudentDetail studentDetail, BindingResult result) {
    if (result.hasErrors()) {
      return "registerStudent";
    }

    Student student = studentDetail.getStudent();

    StudentService.registerStudent(student);

    return "redirect:/studentList";
  }

  @Autowired
  private StudentService studentService;

  @GetMapping("/update")
  public String showUpdateForm(@RequestParam("id") Long id ,Model model) {
    Student student = studentService.getStudentById(id);
    model.addAttribute("student" , student);
    return  "updateStudent";
  }
  @PostMapping("/update")
  public  String updateStudent(@ModelAttribute("student")Student student){
    studentService.updateStudent(student);
    return "redirect:/student/list";
  }//ここから始める




}
