<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="styles/templatesstyles/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="styles/templatesstyles/bootstrap-theme.min.css" type="text/css">
</head>
<%@include file="layouts/siteNavigation.jspf" %>
<body>


<div class="container">
    <div class="row">
        <div class="col-md-offset-2 col-md-8">
            <table class="table table-striped text-info">
                <thead>
                <tr>
                    <th>Login</th>
                    <th>Name</th>
                    <th>E-mail</th>
                    <th>Registration date</th>
                    <th></th>
                    <th>Block/unblock bill</th>
                    <th>Credit Cards</th>

                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.login}</td>
                        <td>${user.fullName}</td>
                        <td>${user.email}</td>
                        <td>${user.registerDate}</td>
                        <td></td>
                        <td>
                            <c:choose>
                            <c:when test="${user.blocked}">
                            <a class="btn btn-success" href="servlet.do?command=block_user&userId=${user.userId}">Unblock
                                Block client bill</a>
                            </c:when>
                            <c:otherwise>
                            <a class="btn btn-danger" href="servlet.do?command=block_user&userId=${user.userId}">Block
                                client bill</a>
                            </c:otherwise>
                            </c:choose>
                        <td><a class="btn btn-primary" href="servlet.do?command=manageCreditCard">Show Credit Cards</a></td>
                        <td><a class="btn btn-primary" href="servlet.do?command=editUser&userId=${user.userId}">Edit User</a></td>
                        <td><a class="btn btn-primary"
                               href="servlet.do?command=deleteUser&userId=${user.userId}">Delete</a></td>

                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="scripts/templatesscripts/jquery-3.2.1.min.js"></script>
<script src="scripts/templatesscripts/bootstrap.min.js"></script>
</body>
</html>

