package entity;

import constant.AttendanceStatusEnum;
import entity.converter.AttendanceStatusConverter;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "STUDENT_ATTENDANCE")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class StudentAttendance extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ATTENDANCE_NO")
    private Long studentAttendanceNo;

    @ManyToOne
    @JoinColumn(name = "STUDENT_NO", nullable = false)
    private Student student;

    @Column(name = "STUDENT_NO", insertable = false, updatable = false)
    private Long studentNo;

    @ManyToOne
    @JoinColumn(name = "SCHEDULE_NO", nullable = false)
    private Schedule schedule;

    @Column(name = "SCHEDULE_NO", insertable = false, updatable = false)
    private Long scheduleNo;

    @Column(name = "STATUS")
    @Convert(converter = AttendanceStatusConverter.class)
    private AttendanceStatusEnum status;

    @Override
    public String toString() {
        return studentAttendanceNo + " - " + studentNo + " - " + scheduleNo;
    }

}
