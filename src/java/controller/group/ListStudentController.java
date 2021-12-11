/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.group;

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
import model.StudentDTO;
import service.StudentService;
import service.impl.StudentServiceImpl;

/**
 *
 * @author ADMIN
 */
public class ListStudentController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListStudentController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListStudentController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String groupNo = request.getParameter("groupNo");
        String scheduleNo = request.getParameter("scheduleNo");
        if (groupNo != null && scheduleNo != null) {
            List<StudentDTO> studentDTOs
                    = studentService.getListStudentByGroupNoAndScheduleNo(Long.valueOf(groupNo), Long.valueOf(scheduleNo));
            request.setAttribute("studentDTOs", studentDTOs);
            request.getRequestDispatcher("../view/group/student-list.jsp").forward(request, response);
        }

    }

    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
