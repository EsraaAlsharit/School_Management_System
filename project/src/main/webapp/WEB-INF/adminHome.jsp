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
                    <nav class="navbar navbar-light p-3" style="background-color: #e3f2fd;">

                        <a class="navbar-brand" href="#">School System</a>

                        <div class="d-flex justify-content-between">
                            <a class="nav-link text-secondary" aria-current="page" href="/add/subject">Add Subject</a>

                            <a class="nav-link text-secondary" href="/logout">Logout</a>
                        </div>
                    </nav>
                    <div class="container my-3">
                        <div class="d-flex justify-content-between">
                            <h2 class="text-primary">Welcome, <c:out value="${manger.userName}"></c:out>!</h2>
                        </div>
                        <div class="">
                            <div class="container m-3 ">
                                <div class="user">
                                    <h3>Users</h3>
                                    <table id="table" class="table table-striped table-bordered text-center">
                                        <thead class="table-primary">
                                            <tr>
                                                <th>Full Name</th>
                                                <th>Email</th>
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
                                                        <c:out value="${user.email}" />
                                                    </td>
                                                    <td>
                                                        <fmt:formatDate value="${user.createdAt}"
                                                            pattern="dd MMM yyyy" />

                                                    </td>
                                                    <td>
                                                        <form action="/role/${user.id}" method="post" class="row">
                                                            <div class="form-group col-6">
                                                                <select name="role" class="form-control">
                                                                    <option value="student">Student</option>
                                                                    <option value="teacher">Teacher</option>
                                                                </select>
                                                            </div>
                                                            <div class=" col-6">
                                                                <input type="submit" value="Assign"
                                                                    class="btn btn-secondary">
                                                            </div>
                                                        </form>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>

                                <div class="Students">
                                    <h3>Students</h3>
                                    <table id="table" class="table table-striped table-bordered text-center">
                                        <thead class="table-primary">
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


                                <div class="Teachers">
                                    <h3>Teachers</h3>
                                    <table id="table" class="table table-striped table-bordered text-center">
                                        <thead class="table-primary">
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
                                    <table id="table" class="table table-striped table-bordered text-center">
                                        <thead class="table-primary">
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
                                                    <c:choose>
                                                    <c:when test="${subject.teacher.id!=null}">
                                                    <td>
                                                        <c:out value="${subject.teacher.fName}" />
                                                    </td>
                                                    </c:when>
                                                    <c:otherwise>
                                                    <td>
                                                        <form action="/join/teacher/${subject.id}" method="post" class="row">
                                                            <div class="form-group col-6">
                                                                <select name="joinTeacher" class="form-control">
                                                       <c:forEach var="teacher" items="${teachers}">
                                                                    <option value="${teacher.id}">${teacher.fName}</option>
                                                       </c:forEach>
                                                                    
                                                                </select>
                                                            </div>
                                                            <div class=" col-6">
                                                                <input type="submit" value="Assign"
                                                                    class="btn btn-secondary">
                                                            </div>
                                                        </form>
                                                       
                                            
                                                    </td>
                                                    
                                                    </c:otherwise>
                                                    </c:choose>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </body>

                </html>