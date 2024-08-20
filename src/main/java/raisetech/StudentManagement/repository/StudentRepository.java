package raisetech.StudentManagement.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;


@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> search();

  @Select("SELECT * FROM students_courses")
  List<StudentsCourses> searchStudentsCourses();

  @Insert("INSERT INTO students (id,name, nickname, email, town, age, gender, furigana,remark,isDeleted) " +
      "VALUES (#{id}, #{name}, #{nickname}, #{email}, #{town}, #{age}, #{gender}, #{furigana}, #{remark},#{isDeleted})")
 @Options(useGeneratedKeys = true, keyProperty = "id")
  void insert(Student student);}






