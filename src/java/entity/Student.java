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

@Entity
@Table(name = "STUDENT")
public class Student extends BaseEntity {

    @Id
    @Column(name = "STUDENT_NO")
    private int studentNo;

    @Column(name = "STUDENT_NAME")
    private String studentName;

    @Column(name = "STUDENT_CODE", nullable = false, unique = true)
    private String studentCode;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<StudentClass> students;
    
}
