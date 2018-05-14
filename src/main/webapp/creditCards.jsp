
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
                    <th>Number</th>
                    <th>CVS</th>
                    <th>Description</th>
                    <th>Month</th>
                    <th>Year</th>
                    <th>Bill</th>
                    <th>Balance</th>
                    <th>Blocked</th>
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
                         <%--   <c:choose>
                                <c:when test="${creditCard.blocked}">
                                    <a href="servlet.do?command=blockCreditCard&creditCardId=${creditCard.getCreditCardId()}" class="btn btn-success" >Unblock</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="servlet.do?command=blockCreditCard&creditCardId=${creditCard.getCreditCardId()}" class="btn btn-danger" >Block</a>
                                </c:otherwise>
                            </c:choose>--%>


                                <%--<button type="button" class="btn btn-success">Add money</button>--%>
                                <a href="servlet.do?command=showChangeBalance&creditCardId=${creditCard.getCreditCardId()}" class="btn btn-success">Add money</a>

                        </td>
                        <td> <%--<button type="button" class="btn btn-success">Add money</button>--%>
                            <a href="servlet.do?command=deleteCreditCard&creditCardId=${creditCard.getCreditCardId()}" class="btn btn-danger">Delete</a></td>
                        <td> <%--<button type="button" class="btn btn-success">Add money</button>--%>
                            <a href="servlet.do?command=showEditCreditCard&creditCardId=${creditCard.getCreditCardId()}" class="btn btn-info">Edit</a></td>
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