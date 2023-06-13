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
    <link rel="stylesheet" href="/src/main/resources/css/style.css">

    <style></style>
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
<div>
    <h2 style="align: center">Chi tiết sp</h2>
    <form action="/ctsp/them" method="post" enctype="multipart/form-data">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã Chi Tiết Sản Phẩm</label>
                <input type="text" name="MACTSP" class="form-control">
            </div>
            <div class="col-6">
                <label>Mã Vạch</label>
                <input type="text" name="MAVACH" class="form-control">
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mô tả</label>
                <input type="text" name="MOTA" class="form-control">
            </div>
            <div class="col-6">
                <label>Số lượng tồn</label>
                <input type="text" name="SOLUONGTON" class="form-control">
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Gía nhập</label>
                <input type="text" name="GIANHAP" class="form-control">
            </div>
            <div class="col-6">
                <label>Gía bán</label>
                <input type="text" name="GIABAN" class="form-control">
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Màu Sắc</label>
                <select class="form-select" name="IDMAUSAC">
                    <c:forEach items="${ms}" var="ms">
                        <option value="${ms.id}">${ms.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>Dòng sản phẩm</label>
                <select class="form-select" name="IDDONGSP">
                    <c:forEach items="${dsp}" var="dsp">
                        <option value="${dsp.id}">${dsp.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>NSX</label>
                <select class="form-select" name="IDNSX">
                    <c:forEach items="${nsx}" var="nsx">
                        <option value="${nsx.id}">${nsx.TEN}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>Sản Phẩm</label>
                <select class="form-select" name="IDSP">
                    <c:forEach items="${sp}" var="sp">
                        <option value="${sp.id}">${sp.TEN}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Size</label>
                <select class="form-select" name="IDSIZE">
                    <c:forEach items="${size}" var="size">
                        <option value="${size.id}">${size.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>Size</label>
                <select class="form-select" name="IDCHATLIEU">
                    <c:forEach items="${cl}" var="cl">
                        <option value="${cl.id}">${cl.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <br>
        <div class="col-6">
            <label for="image">Choose an image to upload:</label>
            <input type="file" id="image" name="IMG">
        </div>
        <br>
        <button type="submit" class="btn btn-primary">Thêm</button>
    </form>
    <table class="table table-striped mt-3">
        <thead class="table-primary">
        <tr>
            <th scope="col">Tên sản phẩm</th>
            <th scope="col">Tên nhà sản xuất</th>
            <th scope="col">Tên màu sắc</th>
            <th scope="col">Tên dòng sản phẩm</th>
            <th scope="col">Năm bảo hành</th>
            <th scope="col">Mô tả</th>
            <th scope="col">Số lượng tồn</th>
            <th scope="col">Giá nhập</th>
            <th scope="col">Giá bán</th>
            <th colspan="2"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ ctsp }" var="ctsp">
            <tr>
                <td>${ctsp.sanPham.TEN}</td>
                <td>${ctsp.nsx.TEN}</td>
                <td>${ctsp.mauSac.ten}</td>
                <td>${ctsp.dongSP.ten}</td>
                <td>${ctsp.moTa}</td>
                <td>${ctsp.soLuongTon}</td>
                <td>${ctsp.giaNhap}</td>
                <td>${ctsp.giaBan}</td>
                <td>
                    <a href="/ctsp/detail/${ctsp.id}" class="btn btn-primary">Cập nhật</a>
                </td>
                <td>
                    <a href="/ctsp/xoa/${ctsp.id}" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script src="/src/main/resources/js/jquery.min.js"></script>
<script src="/src/main/resources/js/popper.js"></script>
<script src="/src/main/resources/js/bootstrap.min.js"></script>
<script src="/src/main/resources/js/main.js"></script>
</html>
