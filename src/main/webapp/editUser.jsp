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
            <h2>Edit</h2>
            <form action="servlet.do" method="post" >
                <input type="hidden" name="command" value="editUser"/>

                <input type="hidden" name="userId" value="${userId}"/>
                <input type="hidden" name="creditCardId" value="${creditCardId}"/>

                <div class="form-group">
                    <label for="usr">Name:</label>
                    <input name="userName" type="text" class="form-control" id="usr" placeholder="Enter name"  value="${user.getFullName()}">
                </div>
                <div class="form-group">
                    <label for="login">Login:</label>
                    <input name="login" type="text" class="form-control" id="login" placeholder="Enter login"  value="${user.login}">
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input  name="email" type="text" class="form-control" id="email" placeholder="Enter email"  value="${email}">
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-success btn-block"><h4>EDIT</h4></button>
                </div>

            </form>
        </div>
    </div>

</div>

<script src="scripts/templatesscripts/jquery-3.2.1.min.js"></script>
<script src="scripts/templatesscripts/bootstrap.min.js"></script>

</body>
</html>

