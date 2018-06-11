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
            <h2>Adding new credit card</h2>
            <form action="servlet.do" method="post" >
                <input type="hidden" name="command" value="createCreditCard"/>
                <div class="form-group">
                    <label for="creditcardNumber">Number:</label>
                    <input name="creditcardNumber" type="text" class="form-control" id="creditcardNumber" placeholder="Enter number">
                </div>
                <div class="form-group">
                    <label for="login">cMonth:</label>
                    <input name="creditcardMonth" type="text" class="form-control" id="login" placeholder="Enter month">
                </div>
                <div class="form-group">
                    <label for="email">Year:</label>
                    <input  name="creditcardYear" type="text" class="form-control" id="email" placeholder="Enter year">
                </div>
                <div class="form-group">
                    <label for="cvc">CVS:</label>
                    <input name="creditcardCVS" type="text" class="form-control" id="cvc" placeholder="Enter CVS">
                </div>
                <div class="form-group">
                    <label for="bill">Balance:</label>
                    <input name="balance" type="text" class="form-control" id="bill" placeholder="Enter bill">
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <input name="description" type="text" class="form-control" id="description" placeholder="Enter description">
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-success btn-block"><h4>Add card</h4></button>
                </div>

            </form>
        </div>
    </div>
</div>

<script src="scripts/templatesscripts/jquery-3.2.1.min.js"></script>
<script src="scripts/templatesscripts/bootstrap.min.js"></script>
</body>
</html>