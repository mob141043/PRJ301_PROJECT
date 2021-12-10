package entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TEACHER")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Teacher extends BaseEntity {

    @Id
    @Column(name = "TEACHER_NO")
    private int teacherNo;

    @Column(name = "TEACHER_NAME")
    private String teacherName;
    
    @OneToMany(mappedBy = "teacher")
    private List<TeacherGroup> teacherGroups;

}
