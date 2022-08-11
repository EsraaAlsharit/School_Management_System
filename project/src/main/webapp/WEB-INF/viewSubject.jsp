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

          <title>Subject View</title>
          <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
          <link rel="stylesheet" href="/css/style.css" />
        </head>

        <body class="bg-light">
          <nav class="navbar navbar-light p-3" style="background-color: #e3f2fd;">

            <h1 class="navbar-brand text-primary" href="#">School System</h1>

            <div class="d-flex justify-content-between">
              <a class="nav-link text-secondary" href="/index">Home</a>

              <a class="nav-link text-secondary" href="/logout">Logout</a>
            </div>
          </nav>

          <div class="container my-3">

            <div class="d-flex justify-content-between">
              <h2 class="text-info">Title
                <c:out value="${subject.title}" />
              </h2>
              <h3>Taught By
                <c:out value="${subject.teacher.fName}" />
              </h3>
            </div>
            <br>
            <h4>Students</h4>

            <table id="table" class="table table-striped table-bordered text-center">
              <thead class="table-primary">
                <tr>
                  <th>Full Name</th>
                  <th>Email</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="student" items="${subject.students}">
                  <tr>
                    <td>
                      <a href="/Student/${student.id}">
                        <c:out value="${student.fName} ${student.lName}" />
                      </a>
                    </td>
                    <td>
                      <c:out value="${student.email}" />
                    </td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>

          </div>
          </div>
        </body>

        </html>