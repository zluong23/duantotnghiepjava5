<%--
  Created by IntelliJ IDEA.
  User: nguyenvv4
  Date: 22/01/2023
  Time: 11:31
  To change this template use File | Settings | File Templates.
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
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
<form method="post" action="/san-pham/them" class="container">
<%--    <div class="mb-3">--%>
<%--        <label  class="form-label">Ma</label>--%>
<%--        <input type="text" class="form-control" name="ma" value="${mauSac.ma}">--%>
<%--    </div>--%>
<%--    <div class="mb-3">--%>
<%--        <label  class="form-label">Ten</label>--%>
<%--        <input type="text" class="form-control" name="ten" value="${mauSac.ten}">--%>
<%--    </div>--%>
    <button type="submit">Add</button>
    <h2 style="text-align: center">Danh sách sản phẩm </h2>
    <table class="table table-success table-striped">
        <thead>
        <tr>
            <td>ID</td>
            <td>Mã</td>
            <td>Tên</td>
            <td>Action</td>
        </tr>
        </thead>
        <tbdoy>
            <c:forEach items="${listSanPham}" var="sp">
                <tr>
                    <td>${sp.id}</td>
                    <td>${sp.TEN}</td>
<%--                    <td>${sp.MASP}</td>--%>
                    <td>
                        <a href="/san-pham/xoa/${sp.id}" class="btn btn-primary">Xoa</a>
                            <%--                    <a class="btn btn-primary" href="#">Update</a>--%>
                        <a class="btn btn-primary" href="/san-pham/detail/${sp.id}">Detail</a>
                    </td>
                </tr>
            </c:forEach>
        </tbdoy>
    </table>
</form>
</body>
</html>
