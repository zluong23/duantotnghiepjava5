package com.example.duanquanaojava5.Controller;

import com.example.duanquanaojava5.Model.MauSac;
import com.example.duanquanaojava5.Service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@RequestMapping("/mau-sac")
@Controller
public class MauSacController {
    @Autowired
    MauSacService mauSacService;

    @GetMapping("/hien-thi")
    public String hienthi(Model model){
        ArrayList<MauSac> listMauSac = mauSacService.getAll();
        model.addAttribute("listMauSac",listMauSac);
        model.addAttribute("tk",new MauSac());
        return ("/mau_sac/mau_sac");
    }
}
