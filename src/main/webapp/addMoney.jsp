<!DOCTYPE html>
<head>
    <title>addMoney</title>
    <%@ include file="layouts/siteHeader.jspf"%>
</head>

<%@ include file="layouts/siteNavigation.jspf"%>


            <div class="col-md-offset-1 col-md-6">
                <h2>Please adding Money</h2>
                <form action="servlet.do" method="post" >
                    <input type="hidden" name="command" value="addMoney"/>
                    <input type="hidden" name="creditCardId" value="${creditCardId}"/>
                    <div class="form-group">
                        <label for="balance">Adding money:</label>
                        <input name="balance" type="text" class="form-control" id="balance" placeholder="Enter money" value="${requestScope.balance}" >
                    </div>
                    <div class="text-center">
                        <div class="form-group">
                            <button type="submit" class="btn btn-success btn-block"><h4>Adding money</h4></button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<%@ include file="layouts/siteFooter.jspf"%>

