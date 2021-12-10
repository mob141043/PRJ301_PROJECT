package entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @Column(name = "GROUP_NO")
    private int groupNo;

    @ManyToOne
    @JoinColumn(name = "COURSE_NO", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "ClASS_NO", nullable = false)
    private Class classVar;

    @OneToMany(mappedBy = "group")
    private List<Schedule> schedules;
}
