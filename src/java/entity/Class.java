package entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLASS")
public class Class extends BaseEntity {

    @Id
    @Column(name = "CLASS_NO")
    private int classNo;

    @Column(name = "CLASS_NAME")
    private String className;
    
    @OneToMany(mappedBy = "classVar", fetch = FetchType.LAZY)
    private List<StudentClass> classes;
}
