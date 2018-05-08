 <!DOCTYPE html>
<html>
<head>
    <title>Add Credit Card</title>
    <link rel="stylesheet" href="styles/templatesstyles/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="styles/templatesstyles/bootstrap-theme.min.css" type="text/css">
</head>
<body>
<nav class="navbar navbar-inverse">

        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="#"><a href="home.jsp">Home</a></li>
                <li class="#"><a href="users.jsp">Users</a></li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="registration.jsp"><span class=""></span>Register</a></li>
                <li><a href="login.jsp"><span class=""></span>Login</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-9">
            <h2>Adding new credit card</h2>
            <form action="servlet.do" method="post" >
                <input type="hidden" name="command" value="createCreditCard"/>
                <div class="form-group">
                    <label for="usr">Number:</label>
                    <input name="creditcardNumber" type="text" class="form-control" id="usr" placeholder="Enter number">
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
                    <label for="pwd">CVS:</label>
                    <input name="creditcardCVS" type="text" class="form-control" id="pwd" placeholder="Enter CVS">
                </div>
                <div class="form-group">
                    <label for="pwd">Balance:</label>
                    <input name="balance" type="text" class="form-control" id="pwd" placeholder="Enter bill">
                </div>
                <div class="form-group">
                    <label for="pwd">Description:</label>
                    <input name="description" type="text" class="form-control" id="pwd" placeholder="Enter description">
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