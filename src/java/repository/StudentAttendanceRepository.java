/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import constant.AttendanceStatusEnum;
import entity.StudentAttendance;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface StudentAttendanceRepository {

    public int takeAttendanceForScheduleWithRequestMap(Long scheduleNo, Map<Long, AttendanceStatusEnum> studentAttendanceStatusMap);
    
    public List<StudentAttendance> getListByScheduleNo(Long scheduleNo);
}
