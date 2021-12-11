package entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "STUDENT")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode
public class Student extends BaseEntity {

    @Id
    @Column(name = "STUDENT_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentNo;
    
    @Column(name = "STUDENT_NAME")
    private String studentName;

    @Column(name = "STUDENT_CODE", nullable = false, unique = true)
    private String studentCode;
    
    @Column(name = "STUDENT_IMAGE")
    private String studentImage;

    @OneToMany(mappedBy = "student")
    private List<StudentGroup> studentGroups;

}
