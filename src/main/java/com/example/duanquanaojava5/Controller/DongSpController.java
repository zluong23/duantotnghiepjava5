package com.example.duanquanaojava5.Controller;

import com.example.duanquanaojava5.Model.DongSP;
import com.example.duanquanaojava5.Service.DongSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("tk" ,new DongSP());
        return ("/dong_sp/dong_sp");
    }
}
