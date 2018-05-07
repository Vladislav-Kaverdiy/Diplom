    <!DOCTYPE html>

<html>
<head>
    <title>Login</title>
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

        <div class="col-md-offset-1 col-md-6">
        <h2>Please login</h2>
    <form action="servlet.do" method="post" >
                 <input type="hidden" name="command" value="login"/>
                <div class="form-group">
    <label for="login">Login:</label>
    <input name="login" type="text" class="form-control" id="login" placeholder="Enter login">
        </div>
        <div class="form-group">
    <label for="password">Password:</label>
    <input name="password" type="password" class="form-control" id="password" placeholder="Enter password">
        </div>
        <div class="text-center">
        <button type="submit" name="submit" class="btn btn-primary btn-block" value="Login">Login</button>
        </div>
            </form>
        </div>
    </div>
    </div>
    </div>

<%@ include file="layouts/siteFooter.jspf"%>
