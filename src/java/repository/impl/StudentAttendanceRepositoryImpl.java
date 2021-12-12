/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.impl;

import constant.AttendanceStatusEnum;
import entity.Schedule;
import entity.Student;
import entity.StudentAttendance;
import hibernate.ConnectionUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import model.StudentDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.hibernate.Query;
import repository.StudentAttendanceRepository;

/**
 *
 * @author ADMIN
 */
public class StudentAttendanceRepositoryImpl extends BaseRepository implements StudentAttendanceRepository {

    private static final Logger LOGGER = Logger.getLogger(StudentAttendanceRepositoryImpl.class.getName());

    @Override
    public int takeAttendanceForScheduleWithRequestMap(Long scheduleNo, Map<Long, AttendanceStatusEnum> studentAttendanceStatusMap) {
        if (MapUtils.isEmpty(studentAttendanceStatusMap)) {
            return 0;
        }
        
        Map<Long, StudentAttendance> studentAttendanceMap = new HashMap<>();
        List<StudentAttendance> studentAttendances = getListByScheduleNo(scheduleNo);
        if (CollectionUtils.isNotEmpty(studentAttendances)) {
            studentAttendanceMap = studentAttendances.stream()
                    .collect(Collectors.toMap(StudentAttendance::getStudentNo, Function.identity()));
        }

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            int currentSize = 0;
            Long studentNo;
            for (Map.Entry<Long, AttendanceStatusEnum> entry : studentAttendanceStatusMap.entrySet()) {
                studentNo = entry.getKey();
                StudentAttendance studentAttendance = studentAttendanceMap.get(studentNo);
                if (studentAttendance == null) {
                    studentAttendance = new StudentAttendance();
                }
                studentAttendance.setSchedule(Schedule.builder().scheduleNo(scheduleNo).build());
                studentAttendance.setStudent(Student.builder().studentNo(studentNo).build());
                studentAttendance.setStatus(entry.getValue());
                session.saveOrUpdate(studentAttendance);
                currentSize++;

                if (currentSize == 50) {
                    session.flush();
                    session.clear();
                    currentSize = 0;
                }
            }

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            transaction.rollback();
        } finally {
            transaction.commit();
            ConnectionUtil.finish(session);
        }
        return 1;
    }

    @Override
    public List<StudentAttendance> getListByScheduleNo(Long scheduleNo) {
        List<StudentAttendance> studentAttendances = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("FROM StudentAttendance WHERE schedule.scheduleNo = :scheduleNo");
            Query query = session.createQuery(queryBuilder.toString());
            query.setParameter("scheduleNo", scheduleNo);
            studentAttendances = query.list();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        } finally {
            ConnectionUtil.finish(session);
        }
        return studentAttendances;
    }

}
