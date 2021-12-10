/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TEACHER_GROUP")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TeacherGroup extends BaseEntity {

    @Id
    @Column(name = "TEACHER_GROUP_NO")
    private int teacherGroupNo;

    @ManyToOne
    @JoinColumn(name = "TEACHER_NO", nullable = false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "GROUP_NO", nullable = false)
    private Group group;
}
