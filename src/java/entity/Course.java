package entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "COURSE")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Course extends BaseEntity {

    @Id
    @Column(name = "COURSE_NO")
    private int courseNo;

    @Column(name = "COURSE_NAME")
    private String courseName;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private List<TeacherClass> classes;
}
