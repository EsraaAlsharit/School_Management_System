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

        <body class="bg-light">
          <nav class="navbar navbar-light p-3" style="background-color: #e3f2fd;">

            <h1 class="navbar-brand text-primary" href="#">School System</h1>

            <div class="d-flex justify-content-between">
              <a class="nav-link text-secondary" href="/index">Home</a>

              <a class="nav-link text-secondary" href="/logout">Logout</a>
            </div>
          </nav>
          <div class="container my-3">


            <h2 class="text-info">Welcome, ${Teacher.fName}!</h2>



            <div class="body">
              <div class="view">
                <table id="table" class="table table-striped">
                  <thead>
                    <tr>
                      <th scope="col">Courses</th>
                      <th scope="col">Number of students</th>
                    </tr>
                  </thead>
                  <tbody>

                    <c:forEach var="subject" items="${Teacher.subjects}">
                      <tr>
                        <td>
                          <a href="subject/${subject.id}">
                            <c:out value="${subject.title}" />
                          </a>
                        </td>
                        <td>
                          <c:out value="${subject.students.size()}" />
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>

              </div>
            </div>
          </div>
        </body>

        </html>