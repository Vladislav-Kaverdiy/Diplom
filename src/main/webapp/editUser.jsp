<!DOCTYPE html>
<html>
<head>
    <title>Edit User</title>
    <link rel="stylesheet" href="styles/templatesstyles/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="styles/templatesstyles/bootstrap-theme.min.css" type="text/css">

    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="layouts/siteNavigation.jspf"%>

<div class="container">
    <div class="row">

        <div class="col-md-offset-3 col-md-9">
            <h2><fmt:message key="rs_edit_user" /></h2>
            <form action="servlet.do" method="post" >
                <input type="hidden" name="command" value="editUser"/>

                <input type="hidden" name="userId" value="${userId}"/>
                <input type="hidden" name="creditCardId" value="${creditCardId}"/>

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
                    <button type="submit" class="btn btn-success btn-block"><h4><fmt:message key="rs_edit" /></h4></button>
                </div>

            </form>
        </div>
    </div>

</div>

<script src="scripts/templatesscripts/jquery-3.2.1.min.js"></script>
<script src="scripts/templatesscripts/bootstrap.min.js"></script>

</body>
</html>

