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

                    <td>
                        <a href="servlet.do?command=deletePaymentAdmin&creditCardId=${creditCardId}&paymentId=${userPayment.getPaymentId()}" class="btn btn-danger">Delete</a></td>

                    <td>
                        <c:choose>
                            <c:when test="${userPayment.state}">
                                <a href="servlet.do?command=blockCreditCard&creditCardId=${creditCard.getCreditCardId()}&userId=${userId}"
                                   class="btn btn-success">Sent</a>
                            </c:when>
                            <c:otherwise>
                                <a href="servlet.do?command=blockCreditCard&creditCardId=${creditCard.getCreditCardId()}&userId=${userId}"
                                   class="btn btn-danger">Prepared</a>
                            </c:otherwise>
                        </c:choose>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script src="scripts/templatesscripts/jquery-3.2.1.min.js"></script>
<script src="scripts/templatesscripts/bootstrap.min.js"></script>
</body>
</html>
