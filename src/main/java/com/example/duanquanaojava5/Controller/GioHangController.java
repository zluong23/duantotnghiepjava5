package com.example.duanquanaojava5.Controller;

import com.example.duanquanaojava5.Model.*;
import com.example.duanquanaojava5.Service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
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
    @Autowired
    HoaDonService hoaDonService;
    @Autowired
    HoaDonChiTietService hoaDonChiTietService;

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
           gioHang.setNgayTao(new java.sql.Date(new Date().getTime()));
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
        if (gioHang == null) {
            gioHang = new GioHang();
            gioHang.setNgayTao(new java.sql.Date(new Date().getTime()));
            gioHang.setTrangThai(0);
            gioHang.setKhachHang(khachHang);
            gioHangService.save(gioHang);
        }
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

    @GetMapping("/dat-hang")
    public String datHang(Model model, HttpSession session) {
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
        List<GioHangChiTiet> gioHangChiTiets = gioHangChiTietService.findByGioHangKhachHang(khachHang);
        HoaDon hoaDon = new HoaDon();
        hoaDon.setKhachHang(khachHang);
        hoaDon.setGhiChu("addadad");
        hoaDon.setNgayTao(new java.sql.Date(new Date().getTime()));
        hoaDon.setTrangThai(0);
        hoaDonService.save(hoaDon);
        for (GioHangChiTiet gioHangChiTiet : gioHangChiTiets) {
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setHoaDon(hoaDon);
            hoaDonChiTiet.setSanPham(gioHangChiTiet.getCtsp());
            hoaDonChiTiet.setSoLuong(gioHangChiTiet.getSoLuong());
            hoaDonChiTiet.setDonGia(gioHangChiTiet.getCtsp().getSp().getGiaBan() * gioHangChiTiet.getSoLuong());
            hoaDonChiTiet.setTrangThai(0);
            hoaDonChiTietService.save(hoaDonChiTiet);
            ChiTietSanPham chiTietSanPham = gioHangChiTiet.getCtsp();
            chiTietSanPham.setSoLuongTon(chiTietSanPham.getSoLuongTon()-gioHangChiTiet.getSoLuong());
            chiTietSanPhamService.save(chiTietSanPham);
            gioHangChiTietService.delete(gioHangChiTiet);
            System.out.println("THÊM GIỎ HÀNG THÀNH CÔNG");
        }
        return "redirect:/admin/hoa-don";
    }

}
