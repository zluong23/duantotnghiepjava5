package com.example.duanquanaojava5.Controller;

import com.example.duanquanaojava5.Model.SanPham;
import com.example.duanquanaojava5.Service.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {
    @Autowired
    SanPhamService sanPhamService;

    @GetMapping("/hien-thi")
    public String hienthi(Model model) {
        ArrayList<SanPham> listSanPham = sanPhamService.getallSP();
        model.addAttribute("listSanPham", listSanPham);
        model.addAttribute(("tk"), new SanPham());
        return "san_pham/sanpham";
    }

    @PostMapping("/add")
    public String them(Model model, @Valid @ModelAttribute("tk") SanPham sanPham, BindingResult result,
                       @RequestParam("MASP") String MASP,
                       @RequestParam("TEN") String TEN,
                       @RequestParam("NGAYTAO") Date NGAYTAO,
                       @RequestParam("NGAYSUA") Date NGAYSUA
                      ) {
        if (result.hasErrors()) {
            ArrayList<SanPham> listSanPham = sanPhamService.getallSP();
            model.addAttribute("listSanPham", listSanPham);
            return "san_pham/sanpham";
        }
        sanPham.setMASP(MASP);
        sanPham.setTEN(TEN);
        sanPham.setNGAYTAO(NGAYTAO);
        sanPham.setNGAYSUA(NGAYSUA);
        sanPhamService.them(sanPham);
        ArrayList<SanPham> listSanPham = sanPhamService.getallSP();
        model.addAttribute("listSanPham", listSanPham);
        model.addAttribute(("tk"), new SanPham());
        return "san_pham/sanpham";

    }
}
