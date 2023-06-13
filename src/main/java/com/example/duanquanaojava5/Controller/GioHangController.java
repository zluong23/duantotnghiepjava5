package com.example.duanquanaojava5.Controller;

import com.example.duanquanaojava5.Model.ChiTietSanPham;
import com.example.duanquanaojava5.Model.GioHang;
import com.example.duanquanaojava5.Model.GioHangChiTiet;
import com.example.duanquanaojava5.Model.KhachHang;
import com.example.duanquanaojava5.Service.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/gio-hang")
public class GioHangController {
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    GioHangChiTietService gioHangChiTietService;
    @Autowired
    GioHangService gioHangService;
    @Autowired
    KhachHangService khachHangService;
    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;

    @GetMapping("/cart")
    public String cart(Model model, HttpSession session, HttpServletRequest request) {
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
        if (khachHang == null) {
            session.setAttribute("redirectUrl", request.getRequestURI());
            return "redirect:/login";
        }
        GioHang gioHang = gioHangService.findByKhachHang(khachHang.getMaKhachHang());
        if (gioHang == null) {
            gioHang = new GioHang();
            gioHang.setNgayTao((java.sql.Date) new Date());
            gioHang.setTrangThai(0);
            gioHang.setKhachHang(khachHang);
            gioHangService.save(gioHang);
        }
        List<GioHangChiTiet> gioHangChiTiets = gioHangChiTietService.findByGioHang(gioHang.getMaGioHang());
        double tongGia = gettongGia(gioHangChiTiets);
        double donGia = getdonGia(gioHangChiTiets);
        model.addAttribute("donGia", donGia);
        model.addAttribute("tongGia", tongGia);
        model.addAttribute("giohangct", gioHangChiTiets);
        return "giohang";

    }

    private double gettongGia(List<GioHangChiTiet> list) {
        double tongGia = 0.0;
        for (GioHangChiTiet gioHangChiTiet : list) {
            tongGia += gioHangChiTiet.getCtsp().getSp().getGiaBan() * gioHangChiTiet.getSoLuong();
        }
        return tongGia;
    }

    private double getdonGia(List<GioHangChiTiet> list) {
        double donGia = 0.0;
        for (GioHangChiTiet gioHangChiTiet : list) {
            donGia = gioHangChiTiet.getCtsp().getSp().getGiaBan() * gioHangChiTiet.getSoLuong();
        }
        return donGia;
    }

    @PostMapping("/add-to-cart")
    public String addCard(Model model,
                          @RequestParam("maCTSP") Integer maCTSP,
                          @RequestParam("soLuong") Integer soLuong,
                          HttpSession session, HttpServletRequest request) {
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
        if (khachHang == null) {
            session.setAttribute("redirectUrl", request.getRequestURI());
            return "redirect:/login";
        }
        System.out.println(maCTSP);
        GioHang gioHang = gioHangService.findByKhachHang(khachHang.getMaKhachHang());
        ChiTietSanPham ctsp = chiTietSanPhamService.findById(maCTSP).orElse(null);
        List<GioHangChiTiet> gioHangChiTiets = gioHangChiTietService.findByGioHangAndCtsp(gioHang, ctsp);
        if (gioHangChiTiets.isEmpty()) {
            GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
            gioHangChiTiet.setGioHang(gioHang);
            gioHangChiTiet.setCtsp(ctsp);
            gioHangChiTiet.setTrangThai(0);
            gioHangChiTiet.setSoLuong(soLuong);
            gioHangChiTietService.save(gioHangChiTiet);
        } else {

        }
        GioHangChiTiet gioHangChiTiet = gioHangChiTiets.get(0);
        gioHangChiTiet.setSoLuong(gioHangChiTiet.getSoLuong() + soLuong);
        gioHangChiTietService.save(gioHangChiTiet);
        return "redirect:/detail/" + ctsp.getSp().getMaSanPham();
    }

    @GetMapping("xoa/{maGioHang}")
    public String xoa(@PathVariable("maGioHang") Integer maGioHang) {
        gioHangChiTietService.delete(maGioHang);
        return "redirect:/gio-hang/cart";
    }

}
