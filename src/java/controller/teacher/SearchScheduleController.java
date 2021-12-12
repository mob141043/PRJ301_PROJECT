/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AccountDTO;
import model.ScheduleDTO;
import model.SearchScheduleRequestDTO;
import service.ScheduleService;
import service.impl.ScheduleServiceImpl;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "SearchScheduleController", urlPatterns = {"/teacher/search-schedule"})
public class SearchScheduleController extends HttpServlet {

    private ScheduleService scheduleService = new ScheduleServiceImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchClassName = request.getParameter("searchClassName");
        String searchCourseName = request.getParameter("searchCourseName");
        String searchScheduleDate = request.getParameter("searchScheduleDate");

        SearchScheduleRequestDTO searchScheduleRequestDTO = SearchScheduleRequestDTO.builder()
                .searchClassName(searchClassName)
                .searchCourseName(searchCourseName)
                .searchScheduleDate(searchScheduleDate)
                .build();

        HttpSession session = request.getSession();
        AccountDTO accountDTO = (AccountDTO) session.getAttribute("account");
        if (accountDTO != null) {
            List<ScheduleDTO> scheduleDTOs = scheduleService.searchScheduleForTeacher(accountDTO.getTeacherNo(), searchScheduleRequestDTO);
            request.setAttribute("scheduleDTOs", scheduleDTOs);
            request.getRequestDispatcher("../view/teacher/data-scheduler.jsp").forward(request, response);
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
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
