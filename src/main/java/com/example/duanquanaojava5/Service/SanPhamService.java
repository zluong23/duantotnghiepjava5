package com.example.duanquanaojava5.Service;

import com.example.duanquanaojava5.Model.ChiTietSanPham;
import com.example.duanquanaojava5.Model.SanPham;
import org.springframework.data.domain.Page;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public interface SanPhamService {
    ArrayList<SanPham> getallSP();
    void them(SanPham sanPham);
    Optional<SanPham> findById(Integer maSanPham);
    Page<SanPham> findByPage(int page);
    void save(SanPham sanPham);
//    void xoa(UUID id);
//    Optional<SanPham> findById(UUID id);
}
