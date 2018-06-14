<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
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
        </div>
        <div class="col-md-offset-3 col-md-9">
            <h2><fmt:message key="rs_registration" /></h2>
            <form action="servlet.do" method="post">
                <input type="hidden" name="command" value="registration"/>
                <div class="form-group">
                    <label for="usr"><fmt:message key="rs_name" /></label>
                    <input name="userName" type="text" class="form-control" id="usr" placeholder="<fmt:message key="rs_enter_name" />">
                </div>
                <div class="form-group">
                    <label for="login"><fmt:message key="rs_log" /></label>
                    <input name="login" type="text" class="form-control" id="login" placeholder="<fmt:message key="rs_enter_log" />">
                </div>
                <div class="form-group">
                    <label for="email"><fmt:message key="rs_email" /></label>
                    <input name="email" type="text" class="form-control" id="email" placeholder="<fmt:message key="rs_enter_email" />">
                </div>
                <div class="form-group">
                    <label for="pwd"><fmt:message key="rs_password" /></label>
                    <input name="password" type="password" class="form-control" id="pwd" placeholder="<fmt:message key="rs_enter_password" />">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-success btn-block"><h4><fmt:message key="rs_registers" /></h4></button>
                </div>

            </form>
        </div>
    </div>

</div>

<script src="scripts/templatesscripts/jquery-3.2.1.min.js"></script>
<script src="scripts/templatesscripts/bootstrap.min.js"></script>

</body>
</html>

