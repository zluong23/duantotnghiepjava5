package com.example.duanquanaojava5.Service;

import com.example.duanquanaojava5.Model.ChiTietSanPham;
import com.example.duanquanaojava5.Model.GioHang;
import com.example.duanquanaojava5.Model.GioHangChiTiet;
import com.example.duanquanaojava5.Model.KhachHang;

import java.util.List;

public interface GioHangChiTietService {
    List<GioHangChiTiet> findByGioHang(Integer maGioHang);
    void save(GioHangChiTiet gioHangChiTiet);
    List<GioHangChiTiet>  findByGioHangAndCtsp(GioHang gioHang, ChiTietSanPham ctsp);
    void delete(Integer maGioHang);
    List<GioHangChiTiet> findByGioHangKhachHang(KhachHang khachHang);
    void delete(GioHangChiTiet gioHangChiTiet);
}
