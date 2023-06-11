package com.example.duanquanaojava5.Controller;

import com.example.duanquanaojava5.Model.*;
import com.example.duanquanaojava5.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ctsp")
public class ChiTietSanPhamController {
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

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        ArrayList<ChiTietSanPham> list = ctspSV.getAll();
        ArrayList<MauSac> ms = msSV.getAll();
        ArrayList<DongSP> dsp = dspSV.getAll();
        ArrayList<SanPham> sp = sanPhamService.getallSP();
        ArrayList<ChatLieu> cl = chatLieuSV.getAll();
        ArrayList<Size> size = sizeSV.getAll();
        ArrayList<NSX> nsx = nsxSV.getAll();
        model.addAttribute("ms", ms);
        model.addAttribute("dsp", dsp);
        model.addAttribute("cl", cl);
        model.addAttribute("size", size);
        model.addAttribute("nxs", nsx);
        model.addAttribute("sp", sp);
        model.addAttribute("ctsp", list);
        return "chi_tiet_sp/index";
    }
}
