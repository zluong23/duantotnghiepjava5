package com.example.duanquanaojava5.Controller;

import com.example.duanquanaojava5.Model.HoaDon;
import com.example.duanquanaojava5.Service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class HoaDonController {
    @Autowired
    HoaDonService hoaDonService;

    @GetMapping("/hoa-don")
    public String hienthi(Model model) {
        ArrayList<HoaDon> hoaDons = hoaDonService.getAll();
        model.addAttribute("hoaDon", hoaDons);
        return "admin/hoadon";
    }

    @GetMapping("/xac-nhan/{maHoaDon}")
    public String xacNhan(Model model, @PathVariable("maHoaDon") Integer maHoaDon){
        HoaDon hoaDon = hoaDonService.findById(maHoaDon).orElse(null);
        hoaDon.setTrangThai(1);
        hoaDonService.save(hoaDon);
        return "redirect:/admin/hoa-don";
    }
}
