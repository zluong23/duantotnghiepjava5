<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="${pageContext.servletContext.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
          type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${pageContext.servletContext.contextPath}/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/vendor/datatables/dataTables.bootstrap4.min.css"
          rel="stylesheet">

</head>

<body id="page-top">
<jsp:include page="header.jsp"/>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Danh Sách Sản Phẩm</h1>
    <form action="/admin/import" method="post" enctype="multipart/form-data">
        <input type="file" name="file" accept=".xlsx">
        <input type="submit" value="Import">
    </form>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Hình ảnh</th>
                        <th>Tên Sản Phẩm</th>
                        <th>Thương Hiệu</th>
                        <th>Chất Liệu</th>
                        <th>Kiểu Áo</th>
                        <th>Giá bán</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Hình ảnh</th>
                        <th>Tên Sản Phẩm</th>
                        <th>Thương Hiệu</th>
                        <th>Chất Liệu</th>
                        <th>Kiểu Áo</th>
                        <th>Giá bán</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach items="${sanpham}" var="sp">
                        <tr>
                            <td class="p-0">
                                <div class="col-4 d-flex align-items-center">
                                    <div class="product_cart_item_pic set-bg">
                                        <img src="${pageContext.servletContext.contextPath}/img/sanpham/${sp.hinhAnh}" alt="" class="img-fluid">
                                    </div>
                                </div>
                            </td>
                            <td>${sp.tenSanPham}</td>
                            <td>${sp.th.tenThuongHieu}</td>
                            <td>${sp.cl.tenChatLieu}</td>
                            <td>${sp.dsp.tenDongSP}</td>
                            <td>${sp.giaBan}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
<jsp:include page="footer.jsp"/>

<!-- Bootstrap core JavaScript-->
<script src="${pageContext.servletContext.contextPath}/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${pageContext.servletContext.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="${pageContext.servletContext.contextPath}/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="${pageContext.servletContext.contextPath}/vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="${pageContext.servletContext.contextPath}/js/demo/chart-area-demo.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/demo/chart-pie-demo.js"></script>
<script src="${pageContext.servletContext.contextPath}/vendor/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="${pageContext.servletContext.contextPath}/js/demo/datatables-demo.js"></script>
</body>

</html>