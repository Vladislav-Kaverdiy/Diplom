<!DOCTYPE html>
<html>
<head>
    <title>addMoney</title>
    <link rel="stylesheet" href="styles/templatesstyles/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="styles/templatesstyles/bootstrap-theme.min.css" type="text/css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="layouts/siteNavigation.jspf"%>


            <div class="col-md-offset-1 col-md-6">
                <h2>Please adding Money</h2>
                <form action="servlet.do" method="post" >
                    <input type="hidden" name="command" value="addMoney"/>
                    <input type="hidden" name="creditCardId" value="${creditCardId}"/>
                    <div class="form-group">
                        <label for="balance">Adding money:</label>
                        <input name="balance" type="text" class="form-control" id="balance" placeholder="Enter money"  value= "${ requestScope.balance}">
                    </div>
                    <div class="text-center">
                        <div class="form-group">
                            <button type="submit" class="btn btn-success large"><h1>+</h1></button>
                        </div>
                    </div>
                </form>
            </div>


<script src="scripts/templatesscripts/jquery-3.2.1.min.js"></script>
<script src="scripts/templatesscripts/bootstrap.min.js"></script>
</body>
</html>

