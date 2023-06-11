package com.example.duanquanaojava5.Service.impl;

import com.example.duanquanaojava5.Controller.SanPhamController;
import com.example.duanquanaojava5.Model.SanPham;
import com.example.duanquanaojava5.Repository.SanPhamRepository;
import com.example.duanquanaojava5.Service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamRepository sanPhamRepositoryr ;
    @Override
    public ArrayList<SanPham> getallSP() {
        return (ArrayList<SanPham>) sanPhamRepositoryr.findAll();
    }

    @Override
    public void them(SanPham sanPham) {
        sanPhamRepositoryr.save(sanPham);
    }
}
