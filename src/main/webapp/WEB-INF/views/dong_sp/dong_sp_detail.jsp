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
<jsp:include page="../admin/header.jsp"/>

<!-- Begin Page Content -->
<div class="container-fluid">


    <form:form action="/dongsp/update/${dongSP.maDongSP}" method="post" modelAttribute="tk">
        <div class="col-6">
            <label>Ma</label>
            <form:input type="text" class="form-control" path="maDongSP"/>
            <form:errors path="maDongSP"/>
        </div>
        <div class="col-6">
            <label> Tên </label>
            <form:input type="text" class="form-control" path="tenDongSP"/>
            <form:errors path="tenDongSP"/>
        </div>
        <button type="submit">Update</button>
        <h2 style=text-align:center>Danh sách Dòng Sản Phẩm</h2>
    </form:form>
    <form method="POST" action="/domgsp/import" enctype="multipart/form-data">
        <input type="file" name="file" required>
        <button type="submit">Import</button>
    </form>


</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->
<jsp:include page="../admin/footer.jsp"/>

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