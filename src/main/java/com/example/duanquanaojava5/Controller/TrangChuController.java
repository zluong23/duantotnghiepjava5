package com.example.duanquanaojava5.Controller;

import com.example.duanquanaojava5.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
}
