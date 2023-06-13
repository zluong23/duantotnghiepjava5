<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Male_Fashion Template">
    <meta name="keywords" content="Male_Fashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Male-Fashion | Template</title>
    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
          rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/style.css" type="text/css">
</head>
<body>
<jsp:include page="trang_chu/header.jsp"/>

<!-- Shop Details Section Begin -->
<section class="shop-details">
    <div class="product__details__pic">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="product__details__breadcrumb">
                        <span>Product Details</span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-3 col-md-3">
                    <ul class="nav nav-tabs" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">
                                <div class="product__thumb__pic set-bg"
                                     data-setbg="${pageContext.servletContext.contextPath}/img/sanpham/${sanPham.hinhAnh}">
                                </div>
                            </a>
                        </li>
                    </ul>
                </div>
                <div class="col-lg-6 col-md-9">
                    <div class="tab-content">
                        <div class="tab-pane active" id="tabs-1" role="tabpanel">
                            <div class="product__details__pic__item">
                                <img src="${pageContext.servletContext.contextPath}/img/sanpham/${sanPham.hinhAnh}"
                                     alt="">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="product__details__content">
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="col-lg-8">
                    <div class="product__details__text">
                        <h4>Mã sản phẩm : ${selectedChiTiet.maCTSP}</h4>
                        <h4>${sanPham.tenSanPham}</h4>
                        <h4>Sản phầm còn : ${selectedChiTiet.soLuongTon} cái</h4>
                        <h3>${sanPham.giaBan}.VND</h3>
                        <p>${sanPham.moTa}</p>

                        <div class="product__details__option">
                            <div class="product__details__option">
                                <div class="product__details__option__size">
                                    <form method="post"
                                          action="${pageContext.request.contextPath}/detail/${sanPham.maSanPham}">
                                        <span>Size:</span>
                                        <div class="btn-group" data-toggle="buttons">
                                            <c:forEach items="${sizes}" var="size">
                                                <label class="btn ${size.maSize == selectedMaSize ? 'btn-danger active' : 'btn-secondary'}">
                                                    <input type="radio" id="size_${size.maSize}" name="size"
                                                           value="${size.maSize}"
                                                           onchange="this.form.submit()" ${size.maSize == selectedMaSize ? 'checked' : ''}> ${size.soSize}
                                                </label>
                                            </c:forEach>
                                        </div>
                                        <!-- Thêm trường ẩn để lưu giá trị màu được chọn -->
                                        <input type="hidden" name="mau" value="${selectedMaMau}">
                                    </form>
                                </div>
                                <div class="product__details__option__size">
                                    <form method="post"
                                          action="${pageContext.request.contextPath}/detail/${sanPham.maSanPham}">
                                        <span>Color:</span>
                                        <div class="btn-group" data-toggle="buttons">
                                            <c:forEach items="${mauSacs}" var="mauSac">
                                                <label class="btn ${mauSac.maMauSac == selectedMaMau ? 'btn-danger active' : 'btn-secondary'}">
                                                    <input type="radio" id="mau_${mauSac.maMauSac}" name="mau"
                                                           value="${mauSac.maMauSac}"
                                                           onchange="this.form.submit()" ${mauSac.maMauSac == selectedMaMau ? 'checked' : ''}> ${mauSac.tenMauSac}
                                                </label>
                                            </c:forEach>
                                        </div>
                                        <!-- Thêm trường ẩn để lưu giá trị size được chọn -->
                                        <input type="hidden" name="size" value="${selectedMaSize}">
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="product__details__cart__option">
                        <form id="add-to-cart-form" method="POST"
                              action="${pageContext.request.contextPath}/gio-hang/add-to-cart">
                            <input type="hidden" name="maCTSP" value="${selectedChiTiet.maCTSP}">
                                <div class="quantity">
                                    <div class="pro-qty">
                                        <input type="text" value="1" name="soLuong">
                                    </div>
                                </div>
                                <button class="primary-btn" type="submit">add to cart</button>
                        </form>
                    </div>
                </div>
                </div>
                    <div class="product__details__last__option">
                        <h5><span>Guaranteed Safe Checkout</span></h5>
                        <img src="${pageContext.servletContext.contextPath}/img/shop-details/details-payment.png"
                             alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</section>
<!-- Shop Details Section End -->

<!-- Related Section Begin -->
<section class="related spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h3 class="related-title">Related Product</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-3 col-md-6 col-sm-6 col-sm-6">
                <div class="product__item">
                    <div class="product__item__pic set-bg"
                         data-setbg="${pageContext.servletContext.contextPath}/img/product/product-1.jpg">
                        <span class="label">New</span>
                        <ul class="product__hover">
                            <li>
                                <a href="#"><img src="${pageContext.servletContext.contextPath}/img/icon/heart.png"
                                                 alt=""></a>
                            </li>
                            <li>
                                <a href="#"><img src="${pageContext.servletContext.contextPath}/img/icon/compare.png"
                                                 alt=""> <span>Compare</span></a>
                            </li>
                            <li>
                                <a href="#"><img src="${pageContext.servletContext.contextPath}/img/icon/search.png"
                                                 alt=""></a>
                            </li>
                        </ul>
                    </div>
                    <div class="product__item__text">
                        <h6>Piqué Biker Jacket</h6>
                        <a href="#" class="add-cart">+ Add To Cart</a>
                        <div class="rating">
                            <i class="fa fa-star-o"></i>
                            <i class="fa fa-star-o"></i>
                            <i class="fa fa-star-o"></i>
                            <i class="fa fa-star-o"></i>
                            <i class="fa fa-star-o"></i>
                        </div>
                        <h5>$67.24</h5>
                        <div class="product__color__select">
                            <label for="pc-1">
                                <input type="radio" id="pc-1">
                            </label>
                            <label class="active black" for="pc-2">
                                <input type="radio" id="pc-2">
                            </label>
                            <label class="grey" for="pc-3">
                                <input type="radio" id="pc-3">
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6 col-sm-6">
                <div class="product__item">
                    <div class="product__item__pic set-bg"
                         data-setbg="${pageContext.servletContext.contextPath}/img/product/product-2.jpg">
                        <ul class="product__hover">
                            <li>
                                <a href="#"><img src="${pageContext.servletContext.contextPath}/img/icon/heart.png"
                                                 alt=""></a>
                            </li>
                            <li>
                                <a href="#"><img src="${pageContext.servletContext.contextPath}/img/icon/compare.png"
                                                 alt=""> <span>Compare</span></a>
                            </li>
                            <li>
                                <a href="#"><img src="${pageContext.servletContext.contextPath}/img/icon/search.png"
                                                 alt=""></a>
                            </li>
                        </ul>
                    </div>
                    <div class="product__item__text">
                        <h6>Piqué Biker Jacket</h6>
                        <a href="#" class="add-cart">+ Add To Cart</a>
                        <div class="rating">
                            <i class="fa fa-star-o"></i>
                            <i class="fa fa-star-o"></i>
                            <i class="fa fa-star-o"></i>
                            <i class="fa fa-star-o"></i>
                            <i class="fa fa-star-o"></i>
                        </div>
                        <h5>$67.24</h5>
                        <div class="product__color__select">
                            <label for="pc-4">
                                <input type="radio" id="pc-4">
                            </label>
                            <label class="active black" for="pc-5">
                                <input type="radio" id="pc-5">
                            </label>
                            <label class="grey" for="pc-6">
                                <input type="radio" id="pc-6">
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6 col-sm-6">
                <div class="product__item sale">
                    <div class="product__item__pic set-bg"
                         data-setbg="${pageContext.servletContext.contextPath}/img/product/product-3.jpg">
                        <span class="label">Sale</span>
                        <ul class="product__hover">
                            <li>
                                <a href="#"><img src="${pageContext.servletContext.contextPath}/img/icon/heart.png"
                                                 alt=""></a>
                            </li>
                            <li>
                                <a href="#"><img src="${pageContext.servletContext.contextPath}/img/icon/compare.png"
                                                 alt=""> <span>Compare</span></a>
                            </li>
                            <li>
                                <a href="#"><img src="${pageContext.servletContext.contextPath}/img/icon/search.png"
                                                 alt=""></a>
                            </li>
                        </ul>
                    </div>
                    <div class="product__item__text">
                        <h6>Multi-pocket Chest Bag</h6>
                        <a href="#" class="add-cart">+ Add To Cart</a>
                        <div class="rating">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star-o"></i>
                        </div>
                        <h5>$43.48</h5>
                        <div class="product__color__select">
                            <label for="pc-7">
                                <input type="radio" id="pc-7">
                            </label>
                            <label class="active black" for="pc-8">
                                <input type="radio" id="pc-8">
                            </label>
                            <label class="grey" for="pc-9">
                                <input type="radio" id="pc-9">
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6 col-sm-6">
                <div class="product__item">
                    <div class="product__item__pic set-bg"
                         data-setbg="${pageContext.servletContext.contextPath}/img/product/product-4.jpg">
                        <ul class="product__hover">
                            <li>
                                <a href="#"><img src="${pageContext.servletContext.contextPath}/img/icon/heart.png"
                                                 alt=""></a>
                            </li>
                            <li>
                                <a href="#"><img src="${pageContext.servletContext.contextPath}/img/icon/compare.png"
                                                 alt=""> <span>Compare</span></a>
                            </li>
                            <li>
                                <a href="#"><img src="${pageContext.servletContext.contextPath}/img/icon/search.png"
                                                 alt=""></a>
                            </li>
                        </ul>
                    </div>
                    <div class="product__item__text">
                        <h6>Diagonal Textured Cap</h6>
                        <a href="#" class="add-cart">+ Add To Cart</a>
                        <div class="rating">
                            <i class="fa fa-star-o"></i>
                            <i class="fa fa-star-o"></i>
                            <i class="fa fa-star-o"></i>
                            <i class="fa fa-star-o"></i>
                            <i class="fa fa-star-o"></i>
                        </div>
                        <h5>$60.9</h5>
                        <div class="product__color__select">
                            <label for="pc-10">
                                <input type="radio" id="pc-10">
                            </label>
                            <label class="active black" for="pc-11">
                                <input type="radio" id="pc-11">
                            </label>
                            <label class="grey" for="pc-12">
                                <input type="radio" id="pc-12">
                            </label>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Related Section End -->

<jsp:include page="trang_chu/footer.jsp"/>

<!-- Js Plugins -->

<script src="${pageContext.servletContext.contextPath}/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/jquery.nice-select.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/jquery.nicescroll.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/jquery.magnific-popup.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/jquery.countdown.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/jquery.slicknav.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/mixitup.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/owl.carousel.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/main.js"></script>
</body>
</html>