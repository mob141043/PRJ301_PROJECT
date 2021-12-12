<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
