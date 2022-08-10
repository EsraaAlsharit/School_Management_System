<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
                <!DOCTYPE html>
                <html>

                <head>
                    <meta charset="UTF-8" />
                    <!-- for Bootstrap CSS -->
                    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
                    <!-- YOUR own local CSS -->
                    <link rel="stylesheet" href="/css/main.css" />
                    <!-- For any Bootstrap that uses JS or jQuery-->
                    <script src="/webjars/jquery/jquery.min.js"></script>
                    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
                    <title>Home</title>
                    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
                    <link rel="stylesheet" href="/css/style.css" />
                </head>

                <body>
                    <div class="cont">
                        <div class="cont1">
                            <div class="topnav">
                                <div class="lefnav">
                                    <h4>Welcome, <c:out value="${manger.userName}"></c:out>!</h4>
                                </div>
                                <div class="rightnav">
                                    <a href="/logout" class="btn btn-primary">Logout</a>
                                </div>
                            </div>
                        </div>
                        <div class="body">

                            <div class="user">
                                <h3>Users</h3>
                                <table id="table" class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>Full Name</th>
                                            <th>Created At</th>
                                            <th>Select Roles</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="user" items="${users}">
                                            <tr>
                                                <td>
                                                    <a href="user/${user.id}">
                                                        <c:out value="${user.fName} ${user.lName}" />
                                                    </a>
                                                </td>
                                                <td>
                                                    <c:out value="${user.createdAt}" />
                                                </td>
                                                <td>
                                                    <form action="/role/${user.id}" method="post">
                                                        <select name="role">
                                                            <option value="student">Student</option>
                                                            <option value="teacher">Teacher</option>
                                                        </select>
                                                        <input type="submit" value="Assign">
                                                    </form>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                            <div class="Students">
                                <h3>Students</h3>
                                <table id="table" class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>Full Name</th>
                                            <th>Email</th>
                                            <th>number of subjects</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="student" items="${students}">
                                            <tr>
                                                <td>
                                                    <a href="Student/${student.id}">
                                                        <c:out value="${student.fName} ${student.lName}" />
                                                    </a>
                                                </td>
                                                <td>
                                                    <c:out value="${student.email}" />
                                                </td>
                                                <td>
                                                    <c:out value="${student.subjects.size()}" />
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- problem not working -->

                            <div class="Teachers">
                                <h3>Teachers</h3>
                                <table id="table" class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>Full Name</th>
                                            <th>Email</th>
                                            <th>number of subjects</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="teacher" items="${teachers}">
                                            <tr>
                                                <td>
                                                    <a href="Teacher/">
                                                        <c:out value="${teacher.fName} ${teacher.lName}" />
                                                    </a>
                                                </td>
                                                <td>
                                                    <c:out value="${teacher.email}" />
                                                </td>
                                                <td>
                                                    <c:out value="${teacher.subjects.size()}" />
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                            <div class="Courses">
                                <h3>Courses</h3>
                                <table id="table" class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>Title</th>
                                            <th>Number of students</th>
                                            <th>Teacher</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="subject" items="${subjects}">
                                            <tr>
                                                <td>
                                                    <a href="subject/${subject.id}">
                                                        <c:out value="${subject.title}" />
                                                    </a>
                                                </td>
                                                <td>
                                                    <c:out value="${subject.students.size()}" />
                                                </td>
                                                <td>
                                                    <c:out value="${subject.teacher.fName}" />
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /problem not working -->

                        </div>
                    </div>
                </body>

                </html>