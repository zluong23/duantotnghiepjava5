package com.example.duanquanaojava5.Service;

import com.example.duanquanaojava5.Model.ChatLieu;
import com.example.duanquanaojava5.Model.ChiTietSanPham;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChiTietSanPhamService {
    ArrayList<ChiTietSanPham> getAll();
    Optional<ChiTietSanPham> findById(UUID id);
}
