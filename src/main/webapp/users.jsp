    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@include file="layouts/siteHeader.jspf" %>
        <%@include file="layouts/siteNavigation.jspf" %>

        </tr>

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
                    <a class="btn btn-success" href="servlet.do?command=block_user&login=${user.login}">Unblock Block client bill</a>
                </c:when>
                <c:otherwise>
                    <a class="btn btn-danger" href="servlet.do?command=block_user&login=${user.login}">Block client bill</a>
                </c:otherwise>
            </c:choose>
            <td> <a class="btn btn-primary" href="servlet.do?command=manageCreditCard">Show Credit Cards</a></td>
            <td> <a class="btn btn-primary" href="servlet.do?command=deleteUser&login=${user.login}">Delete</a></td>

            </td>
            </tr>
        </c:forEach>
        </tbody>
        </table>
        </div>
        </div>
        </div>
        <%@include file="layouts/siteFooter.jspf" %>
