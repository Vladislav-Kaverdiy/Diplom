<!DOCTYPE html>
<html xmlns:background="http://java.sun.com/xml/ns/javaee">
<head>
    <title>ERROR</title>
    <link rel="stylesheet" href="styles/templatesstyles/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="styles/templatesstyles/bootstrap-theme.min.css" type="text/css">
</head>
<body>
<%@ include file="layouts/siteNavigation.jspf"%>


<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-9">
         <button type="#" class="btn btn-danger btn-block"><h4>This is Error page!</h4></button>
            <h3>${errorMessage}</h3>
            <h4>${exceptionMessage}</h4>
            </div>
       </div>
  </div>

            <script src="scripts/templatesscripts/jquery-3.2.1.min.js"></script>
            <script src="scripts/templatesscripts/bootstrap.min.js"></script>
</body>
</html>