package com.example.duanquanaojava5.Controller;

import com.example.duanquanaojava5.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TrangChuController {
    @Autowired
    ChiTietSanPhamService ctspSV;
    @Autowired
    MauSacService msSV;
    @Autowired
    NSXService nsxSV;
    @Autowired
    SizeService sizeSV;
    @Autowired
    ChatLieuService chatLieuSV;
    @Autowired
    DongSPService dspSV;
    @Autowired
    SanPhamService sanPhamService;

    @GetMapping("/")
    public String hienthi(Model model) {
        return "index";
    }
}
