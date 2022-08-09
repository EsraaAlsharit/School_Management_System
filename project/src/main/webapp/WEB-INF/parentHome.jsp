<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Home</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css" />
  </head>
  <body>
    <div class="cont">
      <div class="cont1">
        <div class="topnav">
          <div class="lefnav">
            <h4>Welcome, <c:out value="${user.userName}"></c:out>!</h4>
          </div>
          <div class="rightnav">
            <a href="/logout" class="btn btn-primary">Logout</a>
          </div>
        </div>
      </div>
      <div class="body">
            <div class="add">
                <form action="#" method="post">
                    <input type="hidden" name="studentId" value="#">
                    <label>Add Children:</label>
                    <select name="#">
                        <c:forEach var="#" items="#">
                            <option> </option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Add">
                </form>
            </div>
            <div class="view">
                <c:forEach var="#" items="#">
                <table id="table" class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Courses</th>
                        </tr>
                    </thead>
                    <tbody>
                            <tr>
                                <td scope="row"> <a href="#"><c:out value=""></c:out></a></td>
                            </tr>
                        </tbody>
                    </table>
                </c:forEach>
            </div>
      </div>
    </div>
  </body>
</html>
