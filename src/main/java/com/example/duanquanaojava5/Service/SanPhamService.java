package com.example.duanquanaojava5.Service;

import com.example.duanquanaojava5.Model.SanPham;

import java.util.ArrayList;

public interface SanPhamService {
    ArrayList<SanPham> getallSP();
    void them(SanPham sanPham);
}
