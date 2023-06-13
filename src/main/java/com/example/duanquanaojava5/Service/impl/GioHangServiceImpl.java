package com.example.duanquanaojava5.Service.impl;

import com.example.duanquanaojava5.Model.GioHang;
import com.example.duanquanaojava5.Repository.GioHangRepository;
import com.example.duanquanaojava5.Service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GioHangServiceImpl implements GioHangService {

    @Autowired
    GioHangRepository gioHangRepository;
    @Override
    public GioHang findByKhachHang(Integer maKhachHang) {
        return gioHangRepository.findByKhachHangMaKhachHang(maKhachHang);
    }

    @Override
    public void save(GioHang gioHang) {
        gioHangRepository.save(gioHang);
    }
}
