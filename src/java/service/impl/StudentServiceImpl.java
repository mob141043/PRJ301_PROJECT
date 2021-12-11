/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.List;
import model.StudentDTO;
import repository.StudentRepository;
import repository.impl.StudentRepositoryImpl;
import service.StudentService;

/**
 *
 * @author ADMIN
 */
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository = new StudentRepositoryImpl();

    @Override
    public List<StudentDTO> getListStudentByGroupNoAndScheduleNo(Long groupNo, Long scheduleNo) {
        return studentRepository.getListStudentByGroupNoAndScheduleNo(groupNo, scheduleNo);
    }

}
