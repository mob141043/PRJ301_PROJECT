package entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SCHEDULE")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Schedule extends BaseEntity {

    @Id
    @Column(name = "SCHEDULE_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleNo;

    @ManyToOne
    @JoinColumn(name = "GROUP_NO", nullable = false)
    private Group group;

    @Column(name = "SCHEDULE_DATE")
    private Date scheduleDate;
}
