<!DOCTYPE html>
<html>
    <head>
        <title>Registration</title>
        <%@ include file="layouts/siteHeader.jspf"%>
    </head>
<body>
<%@ include file="layouts/siteNavigation.jspf"%>

<div class="container">
    <div class="row">
    <div class="col-md-offset-3 col-md-9">
    <c:if test= "${not empty errors}">
    <c:forEach var="error" items="${errors}">
    <div class="alert alert-danger">
       ${error}
    </div>
    </c:forEach>
    </c:if>
    </div>
        <div class="col-md-offset-3 col-md-9">
            <h2>Register</h2>
            <form action="servlet.do" method="post" >
                <input type="hidden" name="command" value="registration"/>
                <div class="form-group">
                    <label for="usr">Name:</label>
                    <input name="userName" type="text" class="form-control" id="usr" placeholder="Enter name">
                </div>
                <div class="form-group">
                    <label for="login">Login:</label>
                    <input name="login" type="text" class="form-control" id="login" placeholder="Enter login">
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input  name="email" type="text" class="form-control" id="email" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input name="password" type="password" class="form-control" id="pwd" placeholder="Enter password">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-success btn-block"><h4>Register</h4></button>
                </div>

            </form>
        </div>
    </div>
</div>

<%@ include file="layouts/siteFooter.jspf"%>