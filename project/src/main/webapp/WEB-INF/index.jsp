<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>School System</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/login.css" />
  </head>
  <body>
  <div class="topnavIndex">
      <h1 id="welc" style=color:rgb(43,120,228)>School System</h1>
      <p>A place for teams to manage projects</p>
      </div>
    <div class="cont1">
        <div class="reg">
            <form:form action="/register" method="post" modelAttribute="newUser">
                <h1 class="header">Sign-Up</h1>
                <div class="form-group">
                    <label>Username:</label>
                    <form:input path="userName" class="form-control" />
                    <form:errors path="userName" class="text-danger" />
                </div>
                <div class="form-group">
                    <label>Email:</label>
                    <form:input path="email" class="form-control" />
                    <form:errors path="email" class="text-danger" />
                </div>
                <div class="form-group">
                    <label>Password:</label>
                    <form:password path="password" class="form-control" />
                    <form:errors path="password" class="text-danger" />
                </div>
                <div class="form-group">
                    <label>Confirm Password:</label>
                    <form:password path="confirm" class="form-control" />
                    <form:errors path="confirm" class="text-danger" />
                </div>
                <input id="regi" type="submit" value="Register" class="btn btn-primary" />
            </form:form>
        </div>
        <div class="login">
            <form:form action="/login" method="post" modelAttribute="newLogin">
            	  <h1 class="header">Sign-In</h1>
                <div class="form-group">
                    <label>Email:</label>
                    <form:input path="email" class="form-control" />
                    <form:errors path="email" class="text-danger" />
                </div>
                <div class="form-group">
                    <label>Password:</label>
                    <form:password path="password" class="form-control" />
                    <form:errors path="password" class="text-danger" />
                </div>
                <input type="submit" id="logb" value="Login" class="btn btn-primary" />
            </form:form>
        </div>
    </div>
  </body>
</html>
