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

          <title>Student View</title>
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
            <h2 class="text-info">
              <c:out value="${student.fName} ${student.lName}" />
            </h2>
            <p>
              <b>
                Email
              </b>
              <c:out value="${student.email}" />
            </p>
            <h3>Subjects</h3>
            <table>
              <table id="table" class="table table-striped table-bordered text-center">
                <thead class="table-primary">
                  <tr>
                    <th>Subject</th>
                    <th>Teacher</th>
                    <th>Description</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach var="subject" items="${student.subjects}">
                    <tr>
                      <td>
                        <a href="/subject/${subject.id}">
                          <c:out value="${subject.title}" />
                        </a>
                      </td>
                      <td>
                        <a href="/Teacher/${subject.teacher.id}">
                          <c:out value="${subject.teacher.fName} ${subject.teacher.lName}" />

                        </a>
                      </td>
                      <td>
                        <c:out value="${subject.descc}" />
                      </td>
                    </tr>
                  </c:forEach>
                </tbody>
              </table>
            </table>
          </div>
          </div>
        </body>

        </html>