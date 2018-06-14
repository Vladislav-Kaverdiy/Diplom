<!DOCTYPE html>
<html>
    <head>
        <title>Credit cards</title>

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
                    <th><fmt:message key="rs_number" /></th>
                    <th>CVV</th>
                    <th><fmt:message key="rs_description" /></th>
                    <th><fmt:message key="rs_month" /></th>
                    <th><fmt:message key="rs_year" /></th>
                    <th><fmt:message key="rs_bill" /></th>
                    <th><fmt:message key="rs_balance" /></th>
                    <th><fmt:message key="rs_add_money" /></th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="creditCard" items="${creditCards}">
                    <input type="hidden" name="creditCardId" value="${creditCardId}"/>
                    <tr>
                        <td>${creditCard.creditCardNumber}</td>
                        <td>${creditCard.cvs}</td>
                        <td>${creditCard.description}</td>
                        <td>${creditCard.monthExpiration}</td>
                        <td>${creditCard.yearExpiration}</td>
                        <td>${creditCard.bill}</td>
                        <td>${creditCard.balance}</td>
                        <td>
                             <c:choose>
                                 <c:when test="${creditCard.blocked}">
                                     <button type="button" class="btn btn-danger disabled"><fmt:message key="rs_blocked" /></button>
                                 </c:when>
                                 <c:otherwise>
                                     <a href="servlet.do?command=showChangeBalance&creditCardId=${creditCard.getCreditCardId()}" class="btn btn-success"><fmt:message key="rs_addd_money" /></a>
                                 </c:otherwise>
                             </c:choose>
                        </td>
                        <td>
                            <a href="servlet.do?command=deleteCreditCard&creditCardId=${creditCard.getCreditCardId()}" class="btn btn-danger"><fmt:message key="rs_delete" /></a></td>
                        <td>
                            <a href="servlet.do?command=showEditCreditCard&creditCardId=${creditCard.getCreditCardId()}" class="btn btn-info"><fmt:message key="rs_edit" /></a></td>
                        <td>
                            <a href="servlet.do?command=managePayments&creditCardId=${creditCard.getCreditCardId()}" class="btn btn-info"><fmt:message key="rs_show_payment" /></a></td>
                    </tr>
                </c:forEach>
                </tbody
            </table>
            </div>
        </div>
<script src="scripts/templatesscripts/jquery-3.2.1.min.js"></script>
<script src="scripts/templatesscripts/bootstrap.min.js"></script>
</body>
</html>