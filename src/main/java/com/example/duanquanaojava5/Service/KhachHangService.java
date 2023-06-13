package com.example.duanquanaojava5.Service;

import com.example.duanquanaojava5.Model.KhachHang;

public interface KhachHangService {
    KhachHang findByMaKhachHangAndMatKhau(Integer maKhachHang, String matKhau);
}
