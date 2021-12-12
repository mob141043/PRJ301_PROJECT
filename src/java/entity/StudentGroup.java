/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
@Table(name = "STUDENT_GROUP")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StudentGroup extends BaseEntity {

    @Id
    @Column(name = "STUDENT_GROUP_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherGroupNo;

    @ManyToOne
    @JoinColumn(name = "STUDENT_NO", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "GROUP_NO", nullable = false)
    private Group group;
}
