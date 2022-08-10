<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

                <title>School System</title>
                <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
                <link rel="stylesheet" href="/css/login.css" />
            </head>

            <body class="bg-light">
                <nav class="navbar navbar-light p-3" style="background-color: #e3f2fd;">

                    <h1 class="navbar-brand text-primary" href="#">School System</h1>

                    <div class="d-flex justify-content-between">
                        <a class="nav-link text-secondary" href="/admin">I am Admin</a>
                    </div>
                </nav>
                <div class="container my-3">
                    <h2 class="text-info ">User</h2>
                    <div class="row align-items-start d-flex justify-content-around mx-5">
                        <div class="col-6 ">
                            <h3 class="my-2">Sign Up</h3>
                            <form:form action="/register" method="post" modelAttribute="newUser" class="my-3">
                                <div class="form-group my-3">
                                    <label>First Name:<span class="text-danger">*</span></label>
                                    <form:input path="fName" class="form-control" />
                                    <form:errors path="fName" class="text-danger" />
                                </div>
                                <div class="form-group my-3">
                                    <label>Last Name:<span class="text-danger">*</span></label>
                                    <form:input path="lName" class="form-control" />
                                    <form:errors path="lName" class="text-danger" />
                                </div>
                                <div class="form-group my-3">
                                    <label>Email:<span class="text-danger">*</span></label>
                                    <form:input path="email" class="form-control" />
                                    <form:errors path="email" class="text-danger" />
                                </div>
                                <div class="form-group my-3">
                                    <label>Password:<span class="text-danger">*</span></label>
                                    <form:password path="password" class="form-control" />
                                    <form:errors path="password" class="text-danger" />
                                </div>
                                <div class="form-group my-3">
                                    <label>Confirm Password: <span class="text-danger">*</span></label>
                                    <form:password path="confirm" class="form-control" />
                                    <form:errors path="confirm" class="text-danger" />
                                </div>
                                <input type="submit" value="Register" class=" btn btn-primary" />
                            </form:form>
                        </div>
                        <div class="col-6 ">
                            <h3 class="my-2">Sign In</h3>
                            <form:form action="/login" method="post" modelAttribute="newLogin" class="my-3">
                                <div class="form-group my-3">
                                    <label>Email:</label>
                                    <form:input path="email" class="form-control" />
                                    <form:errors path="email" class="text-danger" />
                                </div>
                                <div class="form-group my-3">
                                    <label>Password:</label>
                                    <form:password path="password" class="form-control" />
                                    <form:errors path="password" class="text-danger" />
                                </div>
                                <input type="submit" id="" value="Login" class="btn btn-success" />
                            </form:form>
                        </div>
                    </div>
                </div>
            </body>

            </html>