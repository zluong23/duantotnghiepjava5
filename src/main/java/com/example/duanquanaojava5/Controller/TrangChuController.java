package com.example.duanquanaojava5.Controller;

import com.example.duanquanaojava5.Model.ChiTietSanPham;
import com.example.duanquanaojava5.Model.MauSac;
import com.example.duanquanaojava5.Model.SanPham;
import com.example.duanquanaojava5.Model.Size;
import com.example.duanquanaojava5.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TrangChuController {
    @Autowired
    ChiTietSanPhamService chiTietSanPhamServicel;
    @Autowired
    MauSacService msSV;
    @Autowired
    SizeService sizeSV;
    @Autowired
    ChatLieuService chatLieuSV;
    @Autowired
    DongSPService dspSV;
    @Autowired
    SanPhamService sanPhamService;

    @GetMapping("/")
    public String hienthi(Model model,
                          @RequestParam(defaultValue = "0") int page) {
        Page<SanPham> ctsp = sanPhamService.findByPage(page);
        model.addAttribute("page", ctsp);

        return "index";
    }

    @GetMapping("/test")
    public String hienthi(Model model) {

        return "giohang";
    }

    @GetMapping("/detail/{maSanPham}")
    public String showProductDetails(Model model, @PathVariable("maSanPham") Integer maSanPham) {
        SanPham sanPham = sanPhamService.findById(maSanPham).orElse(null);
        List<MauSac> mauSacs = chiTietSanPhamServicel.findMauSacBymaSanPham(maSanPham);
        List<Size> sizes = chiTietSanPhamServicel.findSizeBymaSanPham(maSanPham);
        List<ChiTietSanPham> chiTietSanPhams = chiTietSanPhamServicel.getChiTietSanPhamByMaSanPhamAndMaSize(maSanPham, sizes.get(0).getMaSize());
        ChiTietSanPham firstChiTiet = chiTietSanPhams.get(0);
        model.addAttribute("sanPham", sanPham);
        model.addAttribute("mauSacs", mauSacs);
        model.addAttribute("sizes", sizes);
        model.addAttribute("chiTietSanPhams", chiTietSanPhams);
        model.addAttribute("selectedMaSanPham", maSanPham);
        model.addAttribute("selectedMaMau", mauSacs.get(0).getMaMauSac());
        model.addAttribute("selectedMaSize", sizes.get(0).getMaSize());
        model.addAttribute("selectedChiTiet", firstChiTiet);

        return "detailSanPham";
    }

    @PostMapping("/detail/{maSanPham}")
    public String showProductDetails(Model model, @PathVariable("maSanPham") Integer maSanPham,
                                     @RequestParam(name = "mau", required = false) Integer maMau,
                                     @RequestParam(name = "size", required = false) Integer maSize) {
        SanPham sanPham = sanPhamService.findById(maSanPham).orElse(null);
        List<MauSac> mauSacs = chiTietSanPhamServicel.findMauSacBymaSanPham(maSanPham);
        List<Size> sizes = chiTietSanPhamServicel.findSizeBymaSanPham(maSanPham);
        ChiTietSanPham selectedChiTiet = null;

        // Lưu giá trị màu được chọn vào thuộc tính selectedMaMau
        Integer selectedMaMau = (Integer) model.getAttribute("selectedMaMau");

        if (maMau != null) {
            if (maSize != null) {
                // Nếu đã chọn size và màu, lấy thông tin chi tiết sản phẩm của size và màu đó
                selectedChiTiet = chiTietSanPhamServicel.getChiTietSanPhamByMaSanPhamAndMaSizeAndMaMauSac(maSanPham, maSize, maMau);
                model.addAttribute("selectedMaMau", maMau);
                model.addAttribute("selectedMaSize", maSize);
            } else {
                // Nếu chỉ chọn màu, lấy danh sách size liên quan đến màu đó và chọn size đầu tiên
                sizes = chiTietSanPhamServicel.findSizeBymaSanPhamAndMaMauSac(maSanPham, maMau);
                if (!sizes.isEmpty()) {
                    maSize = sizes.get(0).getMaSize();
                    selectedChiTiet = chiTietSanPhamServicel.getChiTietSanPhamByMaSanPhamAndMaSizeAndMaMauSac(maSanPham, maSize, maMau);
                }
                // Cập nhật giá trị selectedMaMau vào model để giữ lại màu sắc khi chọn size
                model.addAttribute("selectedMaMau", selectedMaMau);
                model.addAttribute("selectedMaSize", maSize);
            }
        } else {
            if (maSize != null) {
                // Nếu chỉ chọn size, lấy danh sách màu liên quan đến size đó và chọn màu đầu tiên
                List<MauSac> mauSacsBySize = chiTietSanPhamServicel.findMauSacBymaSanPhamAndMaSize(maSanPham, maSize);
                if (!mauSacsBySize.isEmpty()) {
                    maMau = mauSacsBySize.get(0).getMaMauSac();
                    selectedChiTiet = chiTietSanPhamServicel.getChiTietSanPhamByMaSanPhamAndMaSizeAndMaMauSac(maSanPham, maSize, maMau);
                }
                // Cập nhật giá trị selectedMaMau vào model để giữ lại màu sắc khi chọn size
                model.addAttribute("selectedMaMau", selectedMaMau);
                model.addAttribute("selectedMaSize", maSize);
            } else if (!sizes.isEmpty()) {
                // Nếu không chọn gì, lấy size đầu tiên và màu đầu tiên liên quan đến size đó
                maSize = sizes.get(0).getMaSize();
                List<MauSac> mauSacsBySize = chiTietSanPhamServicel.findMauSacBymaSanPhamAndMaSize(maSanPham, maSize);
                if (!mauSacsBySize.isEmpty()) {
                    maMau = mauSacsBySize.get(0).getMaMauSac();
                    selectedChiTiet = chiTietSanPhamServicel.getChiTietSanPhamByMaSanPhamAndMaSizeAndMaMauSac(maSanPham, maSize, maMau);
                }
                // Cập nhật giá trị selectedMaMau vào model để giữ lại màu sắc khi chọn size
                model.addAttribute("selectedMaMau", maMau);
                model.addAttribute("selectedMaSize", maSize);
            }
        }

        model.addAttribute("sanPham", sanPham);
        model.addAttribute("mauSacs", mauSacs);
        model.addAttribute("sizes", sizes);
        model.addAttribute("selectedChiTiet", selectedChiTiet);

        return "detailSanPham";
    }
}
