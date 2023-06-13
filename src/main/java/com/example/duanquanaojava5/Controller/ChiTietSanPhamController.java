package com.example.duanquanaojava5.Controller;

import com.example.duanquanaojava5.Model.*;
import com.example.duanquanaojava5.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/ctsp")
public class ChiTietSanPhamController {
//    @Autowired
//    ChiTietSanPhamService ctspSV;
//    @Autowired
//    MauSacService msSV;
//    @Autowired
//    SizeService sizeSV;
//    @Autowired
//    ChatLieuService chatLieuSV;
//    @Autowired
//    DongSPService dspSV;
//    @Autowired
//    SanPhamService sanPhamService;
//    @Autowired
//    NSXService nsxService;
//
//    @GetMapping("/hien-thi")
//    public String hienThi(Model model) {
//        ArrayList<ChiTietSanPham> list = ctspSV.getAll();
//        ArrayList<MauSac> ms = msSV.getAll();
//        ArrayList<DongSP> dsp = dspSV.getAll();
//        ArrayList<SanPham> sp = sanPhamService.getallSP();
//        ArrayList<ChatLieu> cl = chatLieuSV.getAll();
//        ArrayList<Size> size = sizeSV.getAll();
//        ArrayList<NSX> nsx = nsxService.getAll();
//        model.addAttribute("ms", ms);
//        model.addAttribute("dsp", dsp);
//        model.addAttribute("cl", cl);
//        model.addAttribute("size", size);
//        model.addAttribute("nsx", nsx);
//        model.addAttribute("sp", sp);
//        model.addAttribute("ctsp", list);
//        return "chi_tiet_sp/index";
//    }
//
//    @PostMapping("/them")
//    public String them(Model model,
//                       @RequestParam("IDSP") UUID IDSP,
//                       @RequestParam("IDNSX") UUID IDNSX,
//                       @RequestParam("IDMAUSAC") UUID IDMAUSAC,
//                       @RequestParam("IDDONGSP") UUID IDDONGSP,
//                       @RequestParam("IDSIZE") UUID IDSIZE,
//                       @RequestParam("IDCHATLIEU") UUID IDCHATLIEU,
//                       @RequestParam("MOTA") String MOTA,
//                       @RequestParam("MACTSP") String MACTSP,
//                       @RequestParam("MAVACH") String MAVACH,
//                       @RequestParam("SOLUONGTON") Integer SOLUONGTON,
//                       @RequestParam("GIANHAP") Double GIANHAP,
//                       @RequestParam("IMG") MultipartFile IMG,
//                       @RequestParam("GIABAN") Double GIABAN) throws IOException, SQLException {
//        byte[] img = IMG.getBytes();
//        ChiTietSanPham ctsp = new ChiTietSanPham();
//        SanPham sp = sanPhamService.findById(IDSP).orElse(null);
//        DongSP dsp = dspSV.findById(IDDONGSP).orElse(null);
//        MauSac ms = msSV.findById(IDMAUSAC).orElse(null);
//        NSX nsx = nsxService.findById(IDNSX).orElse(null);
//        Size sz = sizeSV.findById(IDSIZE).orElse(null);
//        ChatLieu cl = chatLieuSV.findById(IDCHATLIEU).orElse(null);
//        ctsp.setSanPham(sp);
//        ctsp.setDongSP(dsp);
//        ctsp.setChatLieu(cl);
//        ctsp.setSize(sz);
//        ctsp.setMauSac(ms);
//        ctsp.setNsx(nsx);
//        ctsp.setGiaNhap(GIANHAP);
//        ctsp.setGiaBan(GIABAN);
//        ctsp.setMoTa(MOTA);
//        ctsp.setMaCTSP(MACTSP);
//        ctsp.setMaVach(MAVACH);
//        ctsp.setSoLuongTon(SOLUONGTON);
//        ctsp.setImg(img);
//        ctspSV.save(ctsp);
//        return "redirect:/ctsp/hien-thi";
//
//    }
//
//    @PostMapping("/import")
//    public String importData(@RequestParam("file") MultipartFile file){
//
//        return "redirect:/san-pham/hien-thi";
//    }
}
