/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.List;
import model.ScheduleDTO;
import model.SearchScheduleRequestDTO;
import repository.ScheduleRepository;
import repository.impl.ScheduleRepositoryImpl;
import service.ScheduleService;

/**
 *
 * @author ADMIN
 */
public class ScheduleServiceImpl implements ScheduleService {

    private ScheduleRepository scheduleRepository = new ScheduleRepositoryImpl();

    @Override
    public List<ScheduleDTO> getListScheduleByTeacherNo(Long teacherNo) {
        return scheduleRepository.getListScheduleByTeacherNo(teacherNo);
    }

    @Override
    public List<ScheduleDTO> searchScheduleForTeacher(Long teacherNo, SearchScheduleRequestDTO scheduleRequestDTO) {
        return scheduleRepository.searchScheduleForTeacher(teacherNo, scheduleRequestDTO);
    }

}
