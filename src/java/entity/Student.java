package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student extends BaseEntity {

    @Id
    private int studentNo;

//    @Column
//    private int age;
}
