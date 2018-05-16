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
                    <th>Recipient Bill</th>
                    <th>Sum</th>
                    <th>Description</th>
                    <th>Creation Date</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="userPayment" items="${userPayment}">
                    <tr>
                        <td>${userPayment.recipientBill}</td>
                        <td>${userPayment.sum}</td>
                        <td>${userPayment.description}</td>
                        <td>${userPayment.creationDate}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="container">
                <div class="row">
                    <div class="col-md-offset-1 col-md-2">
                        <a href="servlet.do?command=showAddPayment&creditCardId=${creditCardId}" class="btn btn-success">Add new Payment</a>
                        <%--<a href="addPayment.jsp" class="btn btn-success btn-lg">Add new Payment</a>--%>
                    </div>
                </div>
        </div>
    </div>
</div>

<script src="scripts/templatesscripts/jquery-3.2.1.min.js"></script>
<script src="scripts/templatesscripts/bootstrap.min.js"></script>
</body>
</html>
