/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.impl;

import constant.AttendanceStatusEnum;
import hibernate.ConnectionUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ScheduleDTO;
import model.StudentDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.Query;
import repository.StudentRepository;

public class StudentRepositoryImpl extends BaseRepository implements StudentRepository {

    private static final Logger LOGGER = Logger.getLogger(StudentRepositoryImpl.class.getName());

    @Override
    public List<StudentDTO> getListStudentByGroupNoAndScheduleNo(Long groupNo, Long scheduleNo) {
        List<StudentDTO> studentDTOs = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT S.STUDENT_NO,S.STUDENT_CODE,S.STUDENT_IMAGE,S.STUDENT_NAME,ISNULL(SA.STATUS,'A') AS ATTENDANCE_STATUS FROM STUDENT S ");
            queryBuilder.append("JOIN STUDENT_GROUP SG ON S.STUDENT_NO = SG.STUDENT_NO ");
            queryBuilder.append("LEFT JOIN (SELECT * FROM STUDENT_ATTENDANCE WHERE SCHEDULE_NO = :scheduleNo) SA on S.STUDENT_NO = SA.STUDENT_NO ");
            queryBuilder.append("WHERE SG.GROUP_NO = :groupNo");

            Query query = session.createSQLQuery(queryBuilder.toString());
            query.setParameter("scheduleNo", scheduleNo);
            query.setParameter("groupNo", groupNo);
            List<Object[]> datas = query.list();
            if (CollectionUtils.isNotEmpty(datas)) {
                for (Object[] data : datas) {
                    StudentDTO studentDTO = new StudentDTO();
                    studentDTO.setStudentNo(((BigInteger) data[0]).longValue());
                    studentDTO.setStudentCode((String) data[1]);
                    studentDTO.setStudentImage((String) data[2]);
                    studentDTO.setStudentName((String) data[3]);
                    studentDTO.setAttendanceStatus(AttendanceStatusEnum.findByValue((String) data[4]));
                    studentDTOs.add(studentDTO);
                }
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        } finally {
            ConnectionUtil.finish(session);
        }
        return studentDTOs;
    }

}
