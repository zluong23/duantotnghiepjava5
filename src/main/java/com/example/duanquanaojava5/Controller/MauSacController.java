package com.example.duanquanaojava5.Controller;

import com.example.duanquanaojava5.Model.DongSP;
import com.example.duanquanaojava5.Model.MauSac;
import com.example.duanquanaojava5.Service.MauSacService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/mau-sac")
@Controller
public class MauSacController {
    @Autowired
    MauSacService mauSacService;

    @GetMapping("/hien-thi")
    public String hienthi(Model model) {
        ArrayList<MauSac> listMauSac = mauSacService.getAll();
        model.addAttribute("listMauSac", listMauSac);
        model.addAttribute("tk", new MauSac());
        return ("/mau_sac/mau_sac");
    }

    @GetMapping("/delete/{maMauSac}")
    public String delete(Model model, @PathVariable("maMauSac") Integer maMauSac) {
        mauSacService.xoa(maMauSac);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/detail/{maMauSac}")
    public String detail(Model model, @PathVariable("maMauSac") Integer maMauSac) {
        MauSac mauSac = mauSacService.findById(maMauSac).orElse(null);
        model.addAttribute("mauSac", mauSac);
        model.addAttribute("tk", mauSac);
        return ("/mau_sac/mau_sac_detail");
    }

    @PostMapping("/add")
    public String add(Model model, @Valid @ModelAttribute("tk") MauSac mauSac, BindingResult result, @RequestParam("tenMauSac") String tenMauSac) {
        if (result.hasErrors()) {
            ArrayList<MauSac> listMauSac = mauSacService.getAll();
            model.addAttribute("listMauSac", listMauSac);
            return ("/mau_sac/mau_sac");
        }
        mauSac.setTenMauSac(tenMauSac);
        mauSacService.them(mauSac);
        ArrayList<MauSac> listMauSac = mauSacService.getAll();
        model.addAttribute("listMauSac", listMauSac);
        model.addAttribute("tk", new MauSac());
        return ("/mau_sac/mau_sac");
    }

    @PostMapping("/update/{maMauSac}")
    public String update(Model model, @PathVariable("maMauSac") Integer maMauSac, @Valid @ModelAttribute("tk") MauSac mauSac, BindingResult result, @RequestParam("tenMauSac") String tenMauSac) {
        if (result.hasErrors()) {
            return ("/mau_sac/mau_sac_detail");
        }
        mauSac.setTenMauSac(tenMauSac);
        mauSacService.sua(mauSac);
        model.addAttribute("tk", new MauSac());
        return "redirect:/mau-sac/hien-thi";
    }
}
