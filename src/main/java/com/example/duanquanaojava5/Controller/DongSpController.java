package com.example.duanquanaojava5.Controller;

import com.example.duanquanaojava5.Model.DongSP;
import com.example.duanquanaojava5.Service.DongSPService;
import jakarta.validation.Valid;
import lombok.experimental.PackagePrivate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/dongsp")
@Controller
public class DongSpController {
    @Autowired
    DongSPService dongSPService;

    @GetMapping("/hien-thi")
    public String hienthi(Model model) {
        ArrayList<DongSP> listDongSp = dongSPService.getAll();
        model.addAttribute("listDongSp", listDongSp);
        model.addAttribute("tk", new DongSP());
        return ("/dong_sp/dong_sp");
    }

    @GetMapping("/delete/{maDongSP}")
    public String delete(Model model, @PathVariable("maDongSP") Integer maDongSP) {
        dongSPService.delete(maDongSP);
        return "redirect:/dongsp/hien-thi";

    }

    @PostMapping("/add")
    public String add(Model model, @Valid @ModelAttribute("tk") DongSP dongSP, BindingResult result, @RequestParam("tenDongSP") String tenDongSP) {
        if (result.hasErrors()) {
            ArrayList<DongSP> listDongSp = dongSPService.getAll();
            model.addAttribute("listDongSp", listDongSp);
            return ("/dong_sp/dong_sp");
        }
        dongSP.setTenDongSP(tenDongSP);
        dongSPService.save(dongSP);
        ArrayList<DongSP> listDongSp = dongSPService.getAll();
        model.addAttribute("listDongSp", listDongSp);
        model.addAttribute("tk", new DongSP());
        return ("/dong_sp/dong_sp");
    }

    @GetMapping("/detail/{maDongSP}")
    public String detail(Model model, @PathVariable("maDongSP") Integer maDongSP) {
        DongSP dongSP = dongSPService.findById(maDongSP).orElse(null);
        model.addAttribute("dongSP", dongSP);
//        ArrayList<DongSP> listDongSp = dongSPService.getAll();
//        model.addAttribute("listDongSp", listDongSp);
        model.addAttribute("tk", dongSP);
        return ("/dong_sp/dong_sp_detail");
    }

    @PostMapping("/update/{maDongSP}")
    public String update(Model model, @PathVariable("maDongSP") Integer maDongSP, @RequestParam("tenDongSP") String tenDongSP) {
        DongSP dongSP = new DongSP();
        dongSP.setMaDongSP(maDongSP);
        dongSP.setTenDongSP(tenDongSP);
        dongSPService.save(dongSP);

        return "redirect:/dongsp/hien-thi";
    }
}
