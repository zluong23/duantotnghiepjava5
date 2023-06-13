package com.example.duanquanaojava5.Service;

import com.example.duanquanaojava5.Model.GioHang;

public interface GioHangService {
    GioHang findByKhachHang(Integer maKhachHang);
    void save(GioHang gioHang);
}
