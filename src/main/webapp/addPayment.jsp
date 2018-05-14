<!DOCTYPE html>
<html>
<head>
    <title>Payment</title>
    <link rel="stylesheet" href="styles/templatesstyles/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="styles/templatesstyles/bootstrap-theme.min.css" type="text/css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="layouts/siteNavigation.jspf"%>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">

            <a class="navbar-brand" href="addPayment.jsp">Payments</a>
        </div>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="registration.jsp"><span class=""></span>Register</a></li>
                <li><a href="login.jsp"><span class=""></span>Login</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-9">
            <h2>Adding new payment</h2>
            <form action="servlet.do" method="post" >
                <input type="hidden" name="command" value="createUserPayment"/>
                <div class="form-group">
                    <label for="confirmationDate">Confirmation Date:</label>
                    <input name="confirmationDate" type="text" class="form-control" id="confirmationDate" placeholder="Enter date">
                </div>
                <div class="form-group">
                    <label for="creationDate">Creation Date:</label>
                    <input name="creationDate" type="text" class="form-control" id="creationDate" placeholder="Enter date">
                </div>
                <div class="form-group">
                    <label for="sum">Sum:</label>
                    <input  name="sum" type="text" class="form-control" id="sum" placeholder="Enter sum">
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <input name="description" type="text" class="form-control" id="description" placeholder="Enter escription">
                </div>
                <div class="form-group">
                    <label for="recipientBill">Bill:</label>
                    <input name="recipientBill" type="text" class="form-control" id="recipientBill" placeholder="Enter bill">
                </div>

                <div class="form-group">

                     <button type="submit" class="btn btn-primary"><h4>Add payment</h4></button>
                </div>

            </form>
        </div>
    </div>
</div>

<script src="scripts/templatesscripts/jquery-3.2.1.min.js"></script>
<script src="scripts/templatesscripts/bootstrap.min.js"></script>
</body>
</html>