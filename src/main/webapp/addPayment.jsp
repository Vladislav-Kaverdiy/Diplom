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

<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-9">
            <c:if test= "${not empty errors}">
                <c:forEach var="error" items="${errors}">
                    <div class="alert alert-danger">
                            ${error}
                    </div>
                </c:forEach>
            </c:if>
        </div>
            <h2><fmt:message key="rs_add_payment" /></h2>
            <form action="servlet.do" method="post" >
                <input type="hidden" name="command" value="addPayment"/>
                <input type="hidden" name="creditCardId" value="${creditCardId}"/>

                <div class="form-group">
                    <label for="sum"><fmt:message key="rs_suma" /></label>
                    <input  name="sum" type="text" class="form-control" id="sum" placeholder="<fmt:message key="rs_enter_suma" />">
                </div>
                <div class="form-group">
                    <label for="description"><fmt:message key="rs_description" /></label>
                    <input name="description" type="text" class="form-control" id="description" placeholder="<fmt:message key="rs_enter_description" />">
                </div>
                <div class="form-group">
                    <label for="recipientBill"><fmt:message key="rs_resipient_bill" /></label>
                    <input name="recipientBill" type="text" class="form-control" id="recipientBill" placeholder="<fmt:message key="rs_enter_recipient_bill" />">
                </div>

                <div class="form-group">
                     <button type="submit" class="btn btn-primary"><h4><fmt:message key="rs_add_payments" /></h4></button>
                </div>

            </form>
        </div>
</div>

<script src="scripts/templatesscripts/jquery-3.2.1.min.js"></script>
<script src="scripts/templatesscripts/bootstrap.min.js"></script>
</body>
</html>