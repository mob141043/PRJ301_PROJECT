/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import constant.AttendanceStatusEnum;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class StudentDTO implements Serializable {

    private Long studentNo;
    private String studentCode;
    private String studentImage;
    private String studentName;
    private AttendanceStatusEnum attendanceStatus;
}
