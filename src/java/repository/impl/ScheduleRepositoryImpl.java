/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.impl;

import hibernate.ConnectionUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ScheduleDTO;
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

}
