<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
                <!DOCTYPE html>
                <html>

                <head>
                    <meta charset="UTF-8">
                    <!-- for Bootstrap CSS -->
                    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
                    <!-- YOUR own local CSS -->
                    <link rel="stylesheet" href="/css/main.css" />
                    <!-- For any Bootstrap that uses JS or jQuery-->
                    <script src="/webjars/jquery/jquery.min.js"></script>
                    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
                    <title>Add Subject</title>
                    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
                    <link rel="stylesheet" href="/css/style.css" />
                </head>

                <body class="bg-light">
                    <nav class="navbar navbar-light p-3" style="background-color: #e3f2fd;">

                        <h1 class="navbar-brand text-primary" href="#">School System</h1>

                        <div class="d-flex justify-content-between">
                            <a class="nav-link text-secondary" href="/index">Home</a>
                            <a class="nav-link text-secondary" href="/add/subject">Add Subject</a>

                            <a class="nav-link text-secondary" href="/logout">Logout</a>
                        </div>
                    </nav>
                    <div class="container my-3">
                        <h2 class="text-info ">Add Subject</h2>
                        <form:form action="/add/subject" method="post" modelAttribute="subject">
                            <p class="errors">
                            </p>
                            <div class="form">
                                <div class="form-group my-3">
                                    <form:label path="title">Title: <span class="text-danger">*</span></form:label>
                                    <form:input path="title" class="form-control" />
                                    <form:errors path="title" class="text-danger" />
                                </div>
                                <div class="form-group my-3">
                                    <form:label path="descc">Description: <span class="text-danger">*</span>
                                    </form:label>
                                    <form:textarea path="descc" class="form-control" rows="5" />
                                    <form:errors path="descc" class="text-danger" />
                                </div>
                                <input type="submit" value="Create" class="btn btn-primary" />
                            </div>
                        </form:form>
                    </div>
                </body>

                </html>