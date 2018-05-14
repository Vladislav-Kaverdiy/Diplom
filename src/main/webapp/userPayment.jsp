<!DOCTYPE html>
<html>
    <head>
        <title>User Payment</title>
        <link rel="stylesheet" href="styles/templatesstyles/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="styles/templatesstyles/bootstrap-theme.min.css" type="text/css">

        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
<body>
<%@ include file="layouts/siteNavigation.jspf"%>


    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Confirmation Date</th>
                    <th>Creation Date</th>
                    <th>Sum</th>
                    <th>Description</th>
                    <th>Bill</th>


                </tr>
                </thead>
                <tbody>
                <c:forEach var="creditCard" items="${creditCards}">
                    <tr>
                        <td>${userPayment.confirmationDate}</td>
                        <td>${userPayment.creationDate}</td>
                        <td>${userPayment.sum}</td>
                        <td>${userPayment.description}</td>
                        <td>${userPayment.recipientBill}</td>


                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="container">
                <div class="row">
                    <div class="col-md-offset-1 col-md-2">
                        <a href="addPayment.jsp" class="btn btn-success btn-lg">Add new Payment</a>
                    </div>
                </div>
        </div>
    </div>
</div>

<script src="scripts/templatesscripts/jquery-3.2.1.min.js"></script>
<script src="scripts/templatesscripts/bootstrap.min.js"></script>
</body>
</html>
