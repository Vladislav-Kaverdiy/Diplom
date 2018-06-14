<!DOCTYPE html>
<head>
    <title>ERROR</title>
    <link rel="stylesheet" href="styles/templatesstyles/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="styles/templatesstyles/bootstrap-theme.min.css" type="text/css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="layouts/siteNavigation.jspf"%>


<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-9">
         <button type="#" class="btn btn-danger btn-block"><h2><fmt:message key="rs_error" /></h2></button>
            <h3>${errorMessage}</h3>
            <h4>${exceptionMessage}</h4>
            </div>
       </div>
  </div>

            <script src="scripts/templatesscripts/jquery-3.2.1.min.js"></script>
            <script src="scripts/templatesscripts/bootstrap.min.js"></script>
</body>
</html>