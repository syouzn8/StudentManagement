package raisetech.StudentManagement.data;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentsCourses {

  private String id;
  private String student_id;
  private String coursName;
  private LocalDateTime start_date;
  private LocalDateTime end_date;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getStudent_id() {
    return student_id;
  }

  public void setStudent_id(String student_id) {
    this.student_id = student_id;
  }

  public String getCoursName() {
    return coursName;
  }

  public void setCoursName(String coursName) {
    this.coursName = coursName;
  }

  public LocalDateTime getStart_date() {
    return start_date;
  }

  public void setStart_date(LocalDateTime start_date) {
    this.start_date = start_date;
  }

  public LocalDateTime getEnd_date() {
    return end_date;
  }

  public void setEnd_date(LocalDateTime end_date) {
    this.end_date = end_date;
  }
}
