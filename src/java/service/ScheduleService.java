package service;

import java.util.List;
import model.ScheduleDTO;

public interface ScheduleService {

    List<ScheduleDTO> getListScheduleByTeacherNo(Long teacherNo);
}
