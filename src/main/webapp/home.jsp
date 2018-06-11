    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ include file="layouts/siteHeader.jspf"%>

    <%--<link rel="stylesheet" href="styles/templatesstyles/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="styles/templatesstyles/bootstrap-theme.min.css" type="text/css">

    <link href="css/bootstrap.min.css" rel="stylesheet">--%>

        <%@ include file="layouts/siteNavigation.jspf"%>

<section id="main-slider" class="no-margin">
    <div class="carousel slide">
        <div class="carousel-inner">
            <div class="item active" style="background-image: url(images/slider/bg1.jpg)">
                <div class="container">
                    <div class="row slide-margin">
                        <div class="col-sm-6">
                            <div class="carousel-content">
                                <h2 class="animation animated-item-1"><fmt:message key="rs_welcome_to" /> <span><fmt:message key="rs_our_banking_company" /> </span></h2>
                                <p class="animation animated-item-2"><fmt:message key="rs_here_to_help" /></p>
                            </div>
                        </div>

                        <div class="col-sm-6 hidden-xs animation animated-item-4">
                            <div class="slider-img">
                                <img src="images/slider/img3.png" class="img-responsive">
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section id="conatcat-info">
    <div class="container">
        <div class="row">
            <div class="col-sm-8">
                <div class="media contact-info wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                    <div class="pull-left">
                        <i class="fa fa-phone"></i>
                    </div>
                    <div class="media-body">
                        <h2><fmt:message key="rs_have_a_question_or_need_a_custom_quote" /></h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
                            labore dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation +0123 456 70
                            80</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
   <%-- <script src="scripts/templatesscripts/jquery-3.2.1.min.js"></script>
    <script src="scripts/templatesscripts/bootstrap.min.js"></script>--%>

        <%@ include file="layouts/siteFooter.jspf"%>