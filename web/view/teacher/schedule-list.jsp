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
                <h3 class="text-center">List of Schedule</h3>
                <hr>
                <div class="container text-left">
                    <table style="border-spacing: 50px;width: 100%">
                        <tbody>
                            <tr>
                                <td><label for="exampleInputEmail1">Class:</label></td>
                                <td><label for="exampleInputEmail1">Course:</label></td>
                            </tr>
                            <tr>
                                <td><input type="text" oninput="searchSchedule()" class="form-control" id ="searchClassName" name="searchClass"   style="width: 500px"/></td>
                                <td><input type="text" oninput="searchSchedule()" class="form-control" id="searchCourseName" name="searchCourse"   style="width: 500px"/></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="container text-left">
                    <label for="exampleInputEmail1">Schedule Date:</label>
                    <input type="Date" class="form-control" oninput="searchSchedule()" id="searchScheduleDate" name="searchScheduleDate" style="width: 500px"/>

                </div>
                <br>
                <div id="content">
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
                        </tbody>

                    </table>
                </div>

                <br>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
            function searchSchedule() {
                var searchClassName = document.getElementById("searchClassName");
                var searchCourseName = document.getElementById("searchCourseName");
                var searchScheduleDate = document.getElementById("searchScheduleDate");

                $.ajax({
                    url: "${pageContext.request.contextPath}/teacher/search-schedule",
                    type: "POST", //send it through get method
                    data: {
                        "searchClassName": searchClassName.value,
                        "searchCourseName": searchCourseName.value,
                        "searchScheduleDate": searchScheduleDate.value
                    },
                    success: function (data) {
                        var row = document.getElementById("content");
                        row.innerHTML = data;
                    },
                    error: function (xhr) {
                        console.log(xhr);
                    }
                });
            }
        </script>
    </body>
</html>
