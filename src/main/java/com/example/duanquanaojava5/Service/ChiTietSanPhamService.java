package com.example.duanquanaojava5.Service;

import com.example.duanquanaojava5.Model.ChatLieu;
import com.example.duanquanaojava5.Model.ChiTietSanPham;
import com.example.duanquanaojava5.Model.MauSac;
import com.example.duanquanaojava5.Model.Size;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChiTietSanPhamService {

    ArrayList<ChiTietSanPham> getAll();

    Optional<ChiTietSanPham> findById(Integer id);

    void save(ChiTietSanPham ctsp);

    Page<ChiTietSanPham> findByPage(int page);

    List<MauSac> findMauSacBymaSanPham(Integer maSanPham);

    List<Size> findSizeBymaSanPham(Integer maSanPham);

    List<Size> findSizeBymaSanPhamAndMaMauSac(Integer maSanPham, Integer maMauSac);

    List<MauSac> findMauSacBymaSanPhamAndMaSize(Integer maSanPham, Integer maSize);

    ChiTietSanPham findBySpMaSanPham(Integer maSanPham);

    List<ChiTietSanPham> getChiTietSanPhamByMaSanPhamAndMaSize(Integer maSanPham, Integer maSize);

    List<ChiTietSanPham> getChiTietSanPhamByMaSanPhamAndMaMauSac(Integer maSanPham, Integer maMauSac);

    ChiTietSanPham getChiTietSanPhamByMaSanPhamAndMaSizeAndMaMauSac(Integer maSanPham, Integer maSize, Integer maMauSac);
}
