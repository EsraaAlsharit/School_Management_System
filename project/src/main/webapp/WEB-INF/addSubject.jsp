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
                    <title>New Category</title>
                    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
                    <link rel="stylesheet" href="/css/style.css" />
                </head>

                <body class="bg-light">
                    <div class="cont">
                        <div class="topnav">
                            <h1>New Subject</h1>
                        </div>
                        <div class="body">
                            <form:form action="/add/subject" method="post" modelAttribute="subject">
                                <p class="errors">
                                    <form:errors path="title" />
                                    <form:errors path="descc" />
                                </p>
                                <div class="form">
                                    <div class="rightForm">
                                        <form:label path="title">Title: </form:label>
                                        <form:label path="descc">Description: </form:label>
                                    </div>
                                    <div class="leftForm">
                                        <form:input path="title" />
                                        <form:input path="descc" />
                                        <input type="submit" value="Create" />
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </body>

                </html>