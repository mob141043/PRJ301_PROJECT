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
                    <a  style="float: right;margin-left: 1460px" href="${pageContext.request.contextPath}/account/logout" class="navbar-brand text-right"> Log Out </a>
                </div>

            </nav>
        </header>
        <br>

        <div class="row">
            <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

            <div class="container">
                <h3 class="text-center">Take Attendance for ${className}</h3>
                <hr>
                <br>
                <form method="POST" action="${pageContext.request.contextPath}/student/take-attendance">
                     <input type="hidden" value="${param.scheduleNo}" name="scheduleNo"/>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Index</th>
                                <th>Image</th>
                                <th>Code</th>
                                <th>Name</th>
                                <th>Present</th>
                                <th>Absent</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                        <c:set var="index" value="1" scope="session"/>

                        <c:forEach var="s" items="${studentDTOs}">
                        <input type="hidden" value="${s.studentNo}" name="studentNo"/>
                            <tr>
                                <td><c:out value="${index}"/></td>
                                <td><img src="${s.studentImage}" style="height: 146px;width: 111px"/></td>
                                <td><c:out value="${s.studentCode}" /></td>
                                <td><c:out value="${s.studentName}" /></td>
                                <td><input type="radio"  name="attendanceStatus${s.studentNo}" ${s.attendanceStatus.value.equals("P") ? 'checked':''} value="P">Present</td>
                                <td><input type="radio"  name="attendanceStatus${s.studentNo}" ${s.attendanceStatus.value.equals("A") ? 'checked':''} value="A">Absent</td>
                            </tr>
                            <c:set var="index" value="${index + 1}" scope="session"/>
                        </c:forEach>
                        <!-- } -->
                        </tbody>

                    </table>
                    <br>
                    <c:if test="${studentDTOs != null && !studentDTOs.isEmpty()}">
                        <div class="container text-right">
                            <input class="btn btn-success" type="submit" value="Save Attendance">
                        </div>
                    </c:if>

                </form>
            </div>
        </div>
    </body>
</html>
