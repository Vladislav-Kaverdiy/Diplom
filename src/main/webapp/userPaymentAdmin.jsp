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
                        <a href="servlet.do?command=deletePaymentAdmin&creditCardId=${creditCardId}&paymentId=${userPayment.getPaymentId()}" class="btn btn-danger"><fmt:message key="rs_delete" /></a></td>

                    <td>
                        <c:choose>
                            <c:when test="${userPayment.state}">
                                <a href="servlet.do?command=changeStatePayment&creditCardId=${creditCardId}&paymentId=${userPayment.getPaymentId()}"
                                   class="btn btn-success"><fmt:message key="rs_sent" /></a>
                            </c:when>
                            <c:otherwise>
                                <a href="servlet.do?command=changeStatePayment&creditCardId=${creditCardId}&paymentId=${userPayment.getPaymentId()}"
                                   class="btn btn-warning"><fmt:message key="rs_prepared" /></a>
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
