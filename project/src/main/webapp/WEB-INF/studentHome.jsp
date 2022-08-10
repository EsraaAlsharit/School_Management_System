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
                  <h4>Welcome, <c:out value="${Student.fName}"></c:out>!</h4>
                </div>
                <div class="rightnav">
                  <a href="/logout" class="btn btn-primary">Logout</a>
                </div>
              </div>
            </div>
            <div class="body">
              <div class="addcourse">
                <form action="/join/subject" method="post">
                  
                  <label>Add Subjects:</label>
                  <select name="subID">
                    <c:forEach var="subject" items="${othersubjects}">
                      <option value="${subject.id}"name="subID">
                        <c:out value="${subject.name}"></c:out>
                      </option>
                    </c:forEach>
                  </select>
                  <input type="submit" value="Add">
                </form>
              </div>
              <div class="viewcourses">
                <table id="table" class="table table-striped">
                  <thead>
                    <tr>
                      <th scope="col">Subject</th>
                      <th scope="col">Teacher</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="subject" items="${Subjects}">
                      <tr>
                        <td scope="row"> <a href="/subject/${subject.id}">
                            <c:out value="${subject.title}"></c:out>
                          </a></td>
                        <td>
                          <c:out value="${subject.teacher}"></c:out>
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