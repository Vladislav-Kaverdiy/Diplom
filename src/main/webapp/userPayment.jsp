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
                    <th><fmt:message key="rs_resipient_bill" /></th>
                    <th><fmt:message key="rs_suma" /></th>
                    <th><fmt:message key="rs_description" /></th>
                    <th><fmt:message key="rs_registration_date" /></th>
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
                            <a href="servlet.do?command=deletePayment&creditCardId=${creditCardId}&paymentId=${userPayment.getPaymentId()}" class="btn btn-danger"><fmt:message key="rs_delete" /></a></td>

                        <td>
                            <a href="servlet.do?command=showEditPayment&creditCardId=${creditCardId}&paymentId=${userPayment.getPaymentId()}" class="btn btn-info"><fmt:message key="rs_edit" /></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="container">
                <div class="row">
                    <div class="col-md-offset-1 col-md-2">
                        <a href="servlet.do?command=showAddPayment&creditCardId=${creditCardId}" class="btn btn-success"><fmt:message key="rs_add_payment" /></a>

                    </div>
                </div>
        </div>
    </div>
</div>

<script src="scripts/templatesscripts/jquery-3.2.1.min.js"></script>
<script src="scripts/templatesscripts/bootstrap.min.js"></script>
</body>
</html>
