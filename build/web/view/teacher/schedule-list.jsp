<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Student Attendance Management </title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-md navbar-dark"
                 style="background-color: tomato">
                <div class="text-left">
                    <a class="navbar-brand"> Student Attendance Management </a>
                    <a href="https://www.javaguides.net" class="navbar-brand text-right"> Log Out </a>
                </div>
                
            </nav>
        </header>
        <br>

        <div class="row">
            <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

            <div class="container">
                <h3 class="text-center">List of Schedule</h3>
                <hr>
                <div class="container text-right">

                    <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Search</a>
                  
                </div>
                <br>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Index</th>
                            <th>Class</th>
                            <th>Course</th>
                            <th>Date</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!--   for (Todo todo: todos) {  -->
                        <c:set var="index" value="1" scope="session"/>
                            
                        <c:forEach var="s" items="${scheduleDTOs}">                            
                            <tr>
                                <td><c:out value="${index}"/></td>
                                <td><c:out value="${s.className}" /></td>
                                <td><c:out value="${s.courseName}" /></td>
                                <td><c:out value="${s.scheduleDate}" /></td>
                                <td><a href="${pageContext.request.contextPath}/group/student-list?scheduleNo=${s.scheduleNo}&groupNo=${s.groupNo}" />Take Attendance</a>
                            </tr>
                            <c:set var="index" value="${index + 1}" scope="session"/>
                        </c:forEach>
                        <!-- } -->
                    </tbody>

                </table>
                <br>
<!--                <div class="container text-right">

                    <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
                        New User</a>
                    <span/>
                </div>-->
            </div>
        </div>
    </body>
</html>
