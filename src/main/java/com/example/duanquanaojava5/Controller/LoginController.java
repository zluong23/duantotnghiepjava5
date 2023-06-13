package com.example.duanquanaojava5.Controller;

import com.example.duanquanaojava5.Model.KhachHang;
import com.example.duanquanaojava5.Service.KhachHangService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    KhachHangService khachHangService;
    @GetMapping("/login")
    public String hienThi(){

        return "trang_chu/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("maKhachHang") Integer maKhachHang,
                        @RequestParam("matKhau") String matKhau,
                        HttpSession session) {
        // Kiểm tra thông tin đăng nhập
        KhachHang khachHang = khachHangService.findByMaKhachHangAndMatKhau(maKhachHang, matKhau);
        if (khachHang == null) {
            // Nếu thông tin đăng nhập không đúng, hiển thị thông báo lỗi và chuyển hướng đến trang đăng nhập
            session.setAttribute("error", "Mã khách hàng hoặc mật khẩu không đúng.");
            return "redirect:/login";
        }

        // Nếu thông tin đăng nhập đúng, lưu thông tin khách hàng vào session
        session.setAttribute("khachHang", khachHang);

        String redirectUrl = (String) session.getAttribute("redirectUrl");
        if (redirectUrl != null) {
            session.removeAttribute("redirectUrl");
            return "redirect:" + redirectUrl;
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        // Xóa session của khách hàng
        session.removeAttribute("khachHang");
        // Chuyển hướng đến trang chủ
        return "redirect:/";
    }
}
