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

            <h1 class="navbar-brand text-primary" href="#">School System</h1>

            <div class="d-flex justify-content-between">
              <a class="nav-link text-secondary" href="/index">Home</a>

              <a class="nav-link text-secondary" href="/logout">Logout</a>
            </div>
          </nav>
          <div class="container my-3">
            <h2 class="text-info">Welcome, <c:out value="${Student.fName}"></c:out>!</h2>

            <div class="row my-5">

              <div class="col-8">
                <table id="table" class="table table-striped table-bordered text-center">
                  <thead class="table-primary">
                    <tr>
                      <th scope="col">Subject</th>
                      <th scope="col">Teacher</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="subject" items="${Student.subjects}">
                      <tr>
                        <td> <a href="/subject/${subject.id}">
                            <c:out value="${subject.title}"></c:out>
                          </a></td>
                        <td>
                          <c:if test="${subject.teacher.fName != null}">
                            <a href="/Teacher/${subject.teacher.id}">
                              <c:out value="${subject.teacher.fName} ${subject.teacher.lName}"></c:out>
                            </a>
                          </c:if>
                          <c:if test="${subject.teacher.fName == null}">
                            Announce Later
                          </c:if>
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>

              <div class="col-4">
                <form action="/join/subject" method="post">
                  <label>Add Subjects:</label>
                  <div class="row align-items-center">
                    <div class="form-group my-3 col-7">
                      <select name="subjectId" class="form-control">
                        <c:forEach var="subject" items="${otherSubjects}">
                          <option value="${subject.id}">
                            <c:out value="${subject.title}" />
                          </option>
                        </c:forEach>
                      </select>
                    </div>
                    <div class="col-3">
                      <input type="submit" value="Add" class="btn btn-success">
                    </div>
                  </div>

                </form>
              </div>
            </div>
          </div>
          </div>
        </body>

        </html>