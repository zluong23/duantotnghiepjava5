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
    </form:form>
    <form method="POST" action="/san-pham/import" enctype="multipart/form-data">
        <input type="file" name="file" required>
        <button type="submit">Import</button>
    </form>
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
</div>
</body>
</html>
