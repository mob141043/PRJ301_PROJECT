package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ACCOUNT")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Account extends BaseEntity {

    @Id
    @Column(name = "ACCOUNT_NO")
    private int accountNo;

    @Column(name = "USER_NAME", unique = true)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "TEACHER_NO", unique = true, updatable = false, insertable = false)
    private int teacherNo;
}
