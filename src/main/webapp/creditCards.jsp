
<!DOCTYPE html>
<html>
    <head>
        <title>Credit cards</title>
        <%@ include file="layouts/siteHeader.jspf"%>
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

                </tr>
                </thead>
                <tbody>
                <c:forEach var="creditCard" items="${creditCards}">
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
                                <button type="button" class="btn btn-danger disabled">Blocked</button>
                            </c:when>
                            <c:otherwise>
                                <%--<button type="button" class="btn btn-success">Add money</button>--%>
                                <a href="servlet.do?command=showChangeBalance&creditCardId=${creditCard.getCreditCardId()}" class="btn btn-success">Add money</a>
                            </c:otherwise>
                        </c:choose>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="container">
                <div class="row">
                    <div class="col-md-offset-1 col-md-2">
                        <a href="addCreditCard.jsp" class="btn btn-success btn-lg">Add new card</a>
                    </div>
                </div>
        </div>
    </div>
</div>

<%@ include file="layouts/siteFooter.jspf"%>