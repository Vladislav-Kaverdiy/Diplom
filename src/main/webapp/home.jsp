    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ include file="layouts/siteHeader.jspf"%>
        <%@ include file="layouts/siteNavigation.jspf"%>

<section id="main-slider" class="no-margin">
    <div class="carousel slide">
        <div class="carousel-inner">
            <div class="item active" style="background-image: url(images/slider/bg1.jpg)">
                <div class="container">
                    <div class="row slide-margin">
                        <div class="col-sm-6">
                            <div class="carousel-content">
                                <h2 class="animation animated-item-1">Welcome to <span>Our Banking Company</span></h2>
                                <p class="animation animated-item-2">We're here to help you manage your money today and
                                    tomorrow...</p>
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
        <%@ include file="layouts/siteFooter.jspf"%>