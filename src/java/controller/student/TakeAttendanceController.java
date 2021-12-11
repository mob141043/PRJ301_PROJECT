/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.student;

import constant.AttendanceStatusEnum;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.StudentAttendanceService;
import service.impl.StudentAttendanceServiceImpl;

/**
 *
 * @author ADMIN
 */
public class TakeAttendanceController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TakeAttendanceController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TakeAttendanceController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String scheduleNo = request.getParameter("scheduleNo");
        String[] studentNos = request.getParameterValues("studentNo");
        if (scheduleNo != null && studentNos != null) {
            Map<Long, AttendanceStatusEnum> studentAttendanceStatusMap = buildStudentAttendanceStatusMap(studentNos, request);
            studentAttendanceService.takeAttendanceForSchedule(Long.valueOf(scheduleNo), studentAttendanceStatusMap);
            response.sendRedirect("../teacher/list-schedule");
        }
    }

    private StudentAttendanceService studentAttendanceService = new StudentAttendanceServiceImpl();

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private Map<Long, AttendanceStatusEnum> buildStudentAttendanceStatusMap(String[] studentNos, HttpServletRequest request) {
        Map<Long, AttendanceStatusEnum> studentAttendanceStatusMap = new HashMap<>();
        String attendanceStatus;
        for (String studentNo : studentNos) {
            attendanceStatus = request.getParameter("attendanceStatus" + studentNo);
            studentAttendanceStatusMap.put(Long.valueOf(studentNo), AttendanceStatusEnum.findByValue(attendanceStatus));
        }
        return studentAttendanceStatusMap;
    }

}
