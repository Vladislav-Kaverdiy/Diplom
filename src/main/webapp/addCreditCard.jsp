 <!DOCTYPE html>
<html>
<head>
    <title>Add Credit Card</title>
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
        <div class="col-md-offset-3 col-md-9">
            <h2><fmt:message key="rs_title_add_card" /></h2>
            <form action="servlet.do" method="post" >
                <input type="hidden" name="command" value="createCreditCard"/>
                <div class="form-group">
                    <label for="creditcardNumber"> <fmt:message key="rs_number" /></label>
                    <input name="creditcardNumber" type="text" class="form-control" id="creditcardNumber" placeholder= "<fmt:message key="rs_numb" />">
                </div>
                <div class="form-group">
                    <label for="login"><fmt:message key="rs_month" /></label>
                    <input name="creditcardMonth" type="text" class="form-control" id="login" placeholder="<fmt:message key="rs_enter_month" />">
                </div>
                <div class="form-group">
                    <label for="email"><fmt:message key="rs_year" /></label>
                    <input  name="creditcardYear" type="text" class="form-control" id="email" placeholder="<fmt:message key="rs_enter_year" />">
                </div>
                <div class="form-group">
                    <label for="cvc">CVV:</label>
                    <input name="creditcardCVS" type="text" class="form-control" id="cvc" placeholder="<fmt:message key="rs_enter" />">
                </div>
                <div class="form-group">
                    <label for="bill"><fmt:message key="rs_bill" /></label>
                    <input name="balance" type="text" class="form-control" id="bill" placeholder="<fmt:message key="rs_enter_bill" />">
                </div>
                <div class="form-group">
                    <label for="description"><fmt:message key="rs_description" /></label>
                    <input name="description" type="text" class="form-control" id="description" placeholder="<fmt:message key="rs_enter_description" />">
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-success btn-block"><h4><fmt:message key="rs_add_credit_card" /></h4></button>
                </div>

            </form>
        </div>
    </div>
</div>

<script src="scripts/templatesscripts/jquery-3.2.1.min.js"></script>
<script src="scripts/templatesscripts/bootstrap.min.js"></script>
</body>
</html>