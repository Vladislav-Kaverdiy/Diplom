<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="styles/templatesstyles/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="styles/templatesstyles/bootstrap-theme.min.css" type="text/css">

    <link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<%@ include file="layouts/siteNavigation.jspf" %>

<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-9">
            <c:if test="${not empty errors}">
                <c:forEach var="error" items="${errors}">
                    <div class="alert alert-danger">
                            ${error}
                    </div>
                </c:forEach>
            </c:if>
            <div class="col-md-offset-1 col-md-6">
                <h2><fmt:message key="rs_log_in" /></h2>
                <form action="servlet.do" method="post">
                    <input type="hidden" name="command" value="login"/>
                    <div class="form-group">
                        <label for="login" class="color-input-field"><fmt:message key="rs_log" /></label>
                        <input name="login" type="text" class="form-control" id="login" placeholder="<fmt:message key="rs_enter_log" />">
                    </div>
                    <div class="form-group">
                        <label for="password"><fmt:message key="rs_password" /></label>
                        <input name="password" type="password" class="form-control" id="password"
                               placeholder="<fmt:message key="rs_enter_password" />">
                    </div>
                    <div class="text-center">
                        <button type="submit" name="submit" class="btn btn-primary btn-block" value="Login"><fmt:message key="rs_enter_login" /></button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="scripts/templatesscripts/jquery-3.2.1.min.js"></script>
<script src="scripts/templatesscripts/bootstrap.min.js"></script>
</body>
</html>

