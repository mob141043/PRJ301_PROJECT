/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.List;
import model.StudentDTO;

public interface StudentRepository {

    public List<StudentDTO> getListStudentByGroupNoAndScheduleNo(Long groupNo, Long scheduleNo);
}
