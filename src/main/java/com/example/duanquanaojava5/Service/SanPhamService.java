package com.example.duanquanaojava5.Service;

import com.example.duanquanaojava5.Model.SanPham;

import java.util.ArrayList;
import java.util.UUID;

public interface SanPhamService {
    ArrayList<SanPham> getallSP();
    void them(SanPham sanPham);
    void xoa(UUID id);
}
