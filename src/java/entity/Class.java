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
@Table(name = "CLASS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Class extends BaseEntity {

    @Id
    @Column(name = "CLASS_NO")
    private int classNo;

    @Column(name = "CLASS_NAME")
    private String className;

    @OneToMany(mappedBy = "classVar", fetch = FetchType.LAZY)
    private List<Group> groups;
}
