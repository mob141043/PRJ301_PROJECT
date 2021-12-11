package entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "[GROUP]",
        uniqueConstraints = {
            @UniqueConstraint(name = "COURSE_AND_CLASS", columnNames = {"COURSE_NO", "ClASS_NO"})})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Group extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROUP_NO")
    private Long groupNo;

    @ManyToOne
    @JoinColumn(name = "COURSE_NO", nullable = false)
    private Course course;

    @Column(name = "COURSE_NO", nullable = false, insertable = false, updatable = false)
    private Long courseNo;

    @ManyToOne
    @JoinColumn(name = "ClASS_NO", nullable = false)
    private Class classVar;

    @Column(name = "ClASS_NO", nullable = false, insertable = false, updatable = false)
    private Long classNo;

    @OneToMany(mappedBy = "group")
    private List<Schedule> schedules;

    @OneToMany(mappedBy = "group")
    private List<StudentGroup> studentGroups;

    @OneToMany(mappedBy = "group")
    private List<TeacherGroup> teacherGroups;
}
