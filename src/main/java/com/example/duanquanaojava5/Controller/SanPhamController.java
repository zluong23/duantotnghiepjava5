package com.example.duanquanaojava5.Controller;

import com.example.duanquanaojava5.Model.SanPham;
import com.example.duanquanaojava5.Service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {
    @Autowired
    SanPhamService sanPhamService;
    @GetMapping("/hien-thi")
    public String hienthi(Model model){
        ArrayList<SanPham> listSanPham = sanPhamService.getallSP();
        model.addAttribute("listSanPham",listSanPham);
        return ("sanpham");
    }
}
