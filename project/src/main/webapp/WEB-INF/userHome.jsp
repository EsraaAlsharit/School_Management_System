<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <%@ page isErrorPage="true" %>
                <!DOCTYPE html>
                <html>

                <head>
                    <meta charset="ISO-8859-1">
                    <!-- for Bootstrap CSS -->
                    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
                    <!-- YOUR own local CSS -->
                    <link rel="stylesheet" href="/css/main.css" />
                    <!-- For any Bootstrap that uses JS or jQuery-->
                    <script src="/webjars/jquery/jquery.min.js"></script>
                    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

                    <title>login & Register</title>
                </head>

                <body class="bg-light">
                    <nav class="navbar navbar-light p-3" style="background-color: #e3f2fd;">

                        <h1 class="navbar-brand text-primary" href="#">School System</h1>

                        <div class="d-flex justify-content-between">
                            <a class="nav-link text-secondary" href="/index">Home</a>

                            <a class="nav-link text-secondary" href="/logout">Logout</a>
                        </div>
                    </nav>
                    <div class="container my-5 text-center">

                        <h2>Welcome ${User.fName}</h2>
                        <p>you have to wait until approval for the Manger of the school</h2>
                        </p>
                    </div>
                </body>

                </html>