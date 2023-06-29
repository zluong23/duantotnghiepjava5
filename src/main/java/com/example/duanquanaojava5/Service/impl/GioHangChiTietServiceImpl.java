package com.example.duanquanaojava5.Service.impl;

import com.example.duanquanaojava5.Model.ChiTietSanPham;
import com.example.duanquanaojava5.Model.GioHang;
import com.example.duanquanaojava5.Model.GioHangChiTiet;
import com.example.duanquanaojava5.Model.KhachHang;
import com.example.duanquanaojava5.Repository.GioHangChiTietRepository;
import com.example.duanquanaojava5.Service.GioHangChiTietService;
import com.example.duanquanaojava5.Service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GioHangChiTietServiceImpl implements GioHangChiTietService {
    @Autowired
    GioHangChiTietRepository gioHangChiTietRepository;

    @Override
    public List<GioHangChiTiet> findByGioHang(Integer maGioHang) {
        return gioHangChiTietRepository.findByGioHangMaGioHang(maGioHang);
    }

    @Override
    public void save(GioHangChiTiet gioHangChiTiet) {
        gioHangChiTietRepository.save(gioHangChiTiet);
    }

    @Override
    public   List<GioHangChiTiet>  findByGioHangAndCtsp(GioHang gioHang, ChiTietSanPham ctsp) {
        return gioHangChiTietRepository.findByGioHangAndAndCtsp(gioHang,ctsp);
    }

    @Override
    public void delete(Integer maGioHang) {
        gioHangChiTietRepository.deleteById(maGioHang);
    }

    @Override
    public List<GioHangChiTiet> findByGioHangKhachHang(KhachHang khachHang) {
        return gioHangChiTietRepository.findByGioHangKhachHang(khachHang);
    }

    @Override
    public void delete(GioHangChiTiet gioHangChiTiet) {
        gioHangChiTietRepository.delete(gioHangChiTiet);
    }
}
