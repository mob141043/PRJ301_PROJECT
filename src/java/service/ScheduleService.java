package service;

import java.util.List;
import model.ScheduleDTO;
import model.SearchScheduleRequestDTO;

public interface ScheduleService {

    List<ScheduleDTO> getListScheduleByTeacherNo(Long teacherNo);
    
    List<ScheduleDTO> searchScheduleForTeacher(Long teacherNo, SearchScheduleRequestDTO scheduleRequestDTO);
}
