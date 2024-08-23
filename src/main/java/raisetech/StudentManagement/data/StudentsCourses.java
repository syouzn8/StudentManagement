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
}
