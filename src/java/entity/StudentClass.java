package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_CLASS")
public class StudentClass extends BaseEntity{
    
    @Id
    @Column(name = "STUDENT_CLASS_NO")
    private int studentClassNo;

    @ManyToOne
    @JoinColumn(name = "STUDENT_NO",nullable = false)
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "ClASS_NO",nullable = false)
    private Class classVar;
}
