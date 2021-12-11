/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import constant.AttendanceStatusEnum;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import repository.StudentAttendanceRepository;
import repository.impl.StudentAttendanceRepositoryImpl;
import service.StudentAttendanceService;

/**
 *
 * @author ADMIN
 */
public class StudentAttendanceServiceImpl implements StudentAttendanceService {

    private StudentAttendanceRepository studentAttendanceRepository = new StudentAttendanceRepositoryImpl();

    @Override
    public int takeAttendanceForSchedule(Long scheduleNo, Map<Long, AttendanceStatusEnum> studentAttendanceStatusMap) {
        return studentAttendanceRepository.takeAttendanceForScheduleWithRequestMap(scheduleNo, studentAttendanceStatusMap);
    }

}
