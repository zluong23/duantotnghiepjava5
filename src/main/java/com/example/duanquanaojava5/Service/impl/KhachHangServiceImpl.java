package com.example.duanquanaojava5.Service.impl;

import com.example.duanquanaojava5.Model.KhachHang;
import com.example.duanquanaojava5.Repository.KhachHangRepository;
import com.example.duanquanaojava5.Service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    KhachHangRepository khachHangRepository;
    @Override
    public KhachHang findByMaKhachHangAndMatKhau(Integer maKhachHang, String matKhau) {
        return khachHangRepository.findByMaKhachHangAndMatKhau(maKhachHang,matKhau);
    }
}
