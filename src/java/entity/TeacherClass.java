package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TEACHER_CLASS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TeacherClass extends BaseEntity {

    @Id
    @Column(name = "TEACHER_CLASS_NO")
    private int teacherClassNo;

    @ManyToOne
    @JoinColumn(name = "TEACHER_NO", nullable = false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "ClASS_NO", nullable = false)
    private Class classVar;
}
