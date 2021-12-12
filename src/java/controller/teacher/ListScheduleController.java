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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AccountDTO;
import model.ScheduleDTO;
import service.ScheduleService;
import service.impl.ScheduleServiceImpl;

/**
 *
 * @author ADMIN
 */
public class ListScheduleController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        AccountDTO accountDTO = (AccountDTO) session.getAttribute("account");
        if (accountDTO != null) {
            List<ScheduleDTO> scheduleDTOs = scheduleService.getListScheduleByTeacherNo(accountDTO.getTeacherNo());
            request.setAttribute("scheduleDTOs", scheduleDTOs);
            request.getRequestDispatcher("../view/teacher/schedule-list.jsp").forward(request, response);
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListScheduleController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListScheduleController at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
    }

    private ScheduleService scheduleService = new ScheduleServiceImpl();

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
