/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.impl;

import hibernate.ConnectionUtil;
import java.math.BigInteger;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ScheduleDTO;
import model.SearchScheduleRequestDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.Query;
import repository.ScheduleRepository;

/**
 *
 * @author ADMIN
 */
public class ScheduleRepositoryImpl extends BaseRepository implements ScheduleRepository {

    private static final Logger LOGGER = Logger.getLogger(ScheduleRepositoryImpl.class.getName());

    @Override
    public List<ScheduleDTO> getListScheduleByTeacherNo(Long teacherNo) {
        List<ScheduleDTO> scheduleDTOs = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT S.SCHEDULE_NO,C.CLASS_NAME,CO.COURSE_NAME,G.GROUP_NO,CAST(FORMAT(S.SCHEDULE_DATE,'dd-MM-yyyy')  AS VARCHAR) SCHEDULE_DATE FROM SCHEDULE S ");
            queryBuilder.append("JOIN [GROUP] G ON G.GROUP_NO = S.GROUP_NO ");
            queryBuilder.append("JOIN TEACHER_GROUP TG on G.GROUP_NO = TG.GROUP_NO ");
            queryBuilder.append("JOIN CLASS C on G.ClASS_NO = C.CLASS_NO ");
            queryBuilder.append("JOIN COURSE CO ON CO.COURSE_NO = G.COURSE_NO ");
            queryBuilder.append("WHERE TG.TEACHER_NO = :teacherNo");

            Query query = session.createSQLQuery(queryBuilder.toString());
            query.setParameter("teacherNo", teacherNo);

            List<Object[]> datas = query.list();
            if (CollectionUtils.isNotEmpty(datas)) {
                for (Object[] data : datas) {
                    ScheduleDTO scheduleDTO = new ScheduleDTO();
                    scheduleDTO.setScheduleNo(((BigInteger) data[0]).longValue());
                    scheduleDTO.setClassName((String) data[1]);
                    scheduleDTO.setCourseName((String) data[2]);
                    scheduleDTO.setGroupNo(((BigInteger) data[3]).longValue());
                    scheduleDTO.setScheduleDate((String) data[4]);
                    scheduleDTOs.add(scheduleDTO);
                }
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        } finally {
            ConnectionUtil.finish(session);
        }
        return scheduleDTOs;
    }

    @Override
    public List<ScheduleDTO> searchScheduleForTeacher(Long teacherNo, SearchScheduleRequestDTO scheduleRequestDTO) {
        List<ScheduleDTO> scheduleDTOs = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("SELECT S.SCHEDULE_NO,C.CLASS_NAME,CO.COURSE_NAME,G.GROUP_NO,CAST(FORMAT(S.SCHEDULE_DATE,'dd-MM-yyyy')  AS VARCHAR) SCHEDULE_DATE FROM SCHEDULE S ");
            queryBuilder.append("JOIN [GROUP] G ON G.GROUP_NO = S.GROUP_NO ");
            queryBuilder.append("JOIN TEACHER_GROUP TG on G.GROUP_NO = TG.GROUP_NO ");
            queryBuilder.append("JOIN CLASS C on G.ClASS_NO = C.CLASS_NO ");
            queryBuilder.append("JOIN COURSE CO ON CO.COURSE_NO = G.COURSE_NO ");
            queryBuilder.append("WHERE TG.TEACHER_NO = :teacherNo");

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("teacherNo", teacherNo);

            String searchClassName = scheduleRequestDTO.getSearchClassName();
            if (searchClassName != null && !searchClassName.isEmpty()) {
                queryBuilder.append(" AND C.CLASS_NAME LIKE :className");
                parameters.put("className", "%" + searchClassName + "%");
            }

            String searchCourseName = scheduleRequestDTO.getSearchCourseName();
            if (searchCourseName != null && !searchCourseName.isEmpty()) {
                queryBuilder.append(" AND CO.COURSE_NAME LIKE :courseName");
                parameters.put("courseName", "%" + searchCourseName + "%");
            }

            String searchScheduleDate = scheduleRequestDTO.getSearchScheduleDate();
            if (searchScheduleDate != null && !searchScheduleDate.isEmpty()) {
                queryBuilder.append(" AND S.SCHEDULE_DATE = :scheduleDate");
                parameters.put("scheduleDate", searchScheduleDate);
            }
            Query query = session.createSQLQuery(queryBuilder.toString());
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
//            query.setParameter("teacherNo", teacherNo);
//            query.setParameter("className", "%" + scheduleRequestDTO.getSearchClassName() + "%");
//            query.setParameter("courseName", "%" + scheduleRequestDTO.getSearchCourseName() + "%");
//            query.setParameter("scheduleDate", scheduleRequestDTO.getSearchScheduleDate());

            List<Object[]> datas = query.list();
            if (CollectionUtils.isNotEmpty(datas)) {
                for (Object[] data : datas) {
                    ScheduleDTO scheduleDTO = new ScheduleDTO();
                    scheduleDTO.setScheduleNo(((BigInteger) data[0]).longValue());
                    scheduleDTO.setClassName((String) data[1]);
                    scheduleDTO.setCourseName((String) data[2]);
                    scheduleDTO.setGroupNo(((BigInteger) data[3]).longValue());
                    scheduleDTO.setScheduleDate((String) data[4]);
                    scheduleDTOs.add(scheduleDTO);
                }
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        } finally {
            ConnectionUtil.finish(session);
        }
        return scheduleDTOs;
    }

}
