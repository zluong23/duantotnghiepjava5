<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body>
<h1>Đăng nhập</h1>
<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>
<form method="post" action="/login">
    <div>
        <label for="maKhachHang">Mã khách hàng:</label>
        <input type="text" id="maKhachHang" name="maKhachHang" required>
    </div>
    <div>
        <label for="matKhau">Mật khẩu:</label>
        <input type="password" id="matKhau" name="matKhau" required>
    </div>
    <div>
        <button type="submit">Đăng nhập</button>
    </div>
</form>
</body>
</html>