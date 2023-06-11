<%--
  Created by IntelliJ IDEA.
  User: nguyenvv4
  Date: 22/01/2023
  Time: 11:31
  To change this template use File | Settings | File Templates.
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>

<%--<form action="/sinh-vien/search" method="post" class="container">--%>

<%--    <div class="mb-3">--%>
<%--        <label class="form-label">Ho Ten</label>--%>
<%--        <input type="text" class="form-control" name="hoTen">--%>
<%--    </div>--%>

<%--    <button type="submit" class="btn btn-primary">Search</button>--%>
<%--</form>--%>

<div class="container">
    <header style="background-color: antiquewhite">
        <h2 style="text-align: center">Trang chủ </h2>

        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a class="nav-link" href="/trang-chu/hien-thi">Trang chủ</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button"
                   aria-expanded="false">Sản
                    phẩm</a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="/mau-sac/hien-thi">Màu sắc</a></li>
                    <li><a class="dropdown-item" href="/nsx/hien-thi">Nhà sản xuất</a></li>
                    <li><a class="dropdown-item" href="/san-pham/hien-thi">Sản phẩm</a></li>
                    <li><a class="dropdown-item" href="/dongsp/hien-thi">Dòng Sản phẩm</a></li>
                    <li><a class="dropdown-item" href="/ctsp/hien-thi">Chi Tiết Sản Phẩm</a></li>
                </ul>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button"
                   aria-expanded="false">Hóa Đơn</a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="/hoa-don/hien-thi">Hóa Đơn</a></li>
                    <li><a class="dropdown-item" href="/hoa-don-chi-tiet/hien-thi">Hóa Đơn Chi Tiết</a></li>

                </ul>
            </li>
            <li class="nav-item">
                <a href="/cart/view" class="nav-link "> Xem giỏ hàng session</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button"
                   aria-expanded="false">Thông tin</a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="/khach-hang/hien-thi">Khách Hàng</a></li>
                    <li><a class="dropdown-item" href="/nhan-vien/hien-thi">Nhân viên</a></li>
                    <li><a class="dropdown-item" href="/cua-hang/hien-thi">Cửa hàng</a></li>
                    <li><a class="dropdown-item" href="/chuc-vu/hien-thi">Chức vụ</a></li>
                </ul>

            </li>
            <div style="margin-left: 200px">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"
                       style="width: 300px">

            </div>

        </ul>

    </header>
    <section>
        <form:form action="/san-pham/add" method="post" modelAttribute="tk">
        <div class="col-6">
            <label>Ma</label>
            <form:input type="text" class="form-control" path="MASP"/>
            <form:errors path="MASP"/>
        </div>
        <div class="col-6">
            <label>Họ</label>
            <form:input type="text" class="form-control" path="TEN"/>
            <form:errors path="TEN"/>
        </div>
        <div class="col-6">
            <label>Ngày Tạo</label>
            <input type="date" name="NGAYTAO" class="form-control">
        </div>
        <div class="col-6">
            <label>Ngày Sửa</label>
            <input type="date" name="NGAYSUA" class="form-control">
        </div>
        <button type="submit">Add</button>
        <h2 style=text-align:center>Danh sách Sản Phẩm</h2>
        <table class="table table-success table-striped">
            <thead>
            <tr>
                <td>ID</td>
                <td>Mã</td>
                <td>Tên</td>
                <td>Ngày Tạo</td>
                <td>Ngày Sửa</td>
                <td>Action</td>
            </tr>
            </thead>
            <tbdoy>
                <c:forEach items="${listSanPham}" var="sp">
                    <tr>
                        <td>${sp.id}</td>
                        <td>${sp.MASP}</td>
                        <td>${sp.TEN}</td>
                        <td>${sp.NGAYTAO}</td>
                        <td>${sp.NGAYSUA}</td>
                        <td>
                            <a href="/san-pham/xoa/${sp.id}" class="btn btn-primary">Xoa</a>
                            <a href="/mau-sac/detail/${ms.id}" class="btn btn-primary">Detail</a>
                                <%--                    <a class="btn btn-primary" href="#">Update</a>--%>

                        </td>
                    </tr>
                </c:forEach>
            </tbdoy>
        </table>
        </form:form>

<section/>
<footer style="background-color: antiquewhite">
    <div class="container">
        <div class="row">
            <div class="col-4 chinhsua2">
                <div><h2>IP14PRM</h2></div>
                <div class="add">Address: 60-49 Road 11378 New York</div>
                <div class="add2">Phone: +65 11.188.888</div>
                <div class="add2">Email: hello@colorlib.com</div>
            </div>
            <div class="col-2 chinhsua2">
                <div><strong>Useful Links</strong></div>
                <div class="add2">About Us</div>
                <div class="add2">h6About Our Shop</div>
                <div class="add2">Secure Shopping</div>
                <div class="add2">Delivery infomation</div>
                <div class="add2">Privacy Policy</div>
                <div class="add2">Our Sitemap</div>
            </div>
            <div class="col-2 chinhsua2">
                <div><strong></strong></div>
                <div class="add2">Who We Are</div>
                <div class="add2">Our Services</div>
                <div class="add2">Projects</div>
                <div class="add2">Contact</div>
                <div class="add2">Innovation</div>
                <div class="add2">Testimonials</div>
            </div>
            <div class="col-4 chinhsua2">
                <div><strong>Join Our Newsletter Now</strong></div>
                <div class="email">
                    Get E-mail updates about our latest shop and special
                </div>
                <div class="entermail">
                    <form action="#">
                        <input type="text" placeholder="Enter your mail"/>
                        <button type="submit" class="site_btn">SUBSCRIBE</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</footer>
</div>
</body>
</html>
