package com.example.duanquanaojava5.Controller;

import com.example.duanquanaojava5.Service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/mau-sac")
@Controller
public class MauSacController {
    @Autowired
    MauSacService mauSacService;
}
