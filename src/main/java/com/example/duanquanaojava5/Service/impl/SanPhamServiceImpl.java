package com.example.duanquanaojava5.Service.impl;

import com.example.duanquanaojava5.Controller.SanPhamController;
import com.example.duanquanaojava5.Model.SanPham;
import com.example.duanquanaojava5.Repository.SanPhamRepository;
import com.example.duanquanaojava5.Service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamRepository sanPhamRepositoryr;

    @Override
    public ArrayList<SanPham> getallSP() {
        return (ArrayList<SanPham>) sanPhamRepositoryr.findAll();
    }

    @Override
    public void them(SanPham sanPham) {
        sanPhamRepositoryr.save(sanPham);
    }

    @Override
    public Optional<SanPham> findById(Integer maSanPham) {
        return sanPhamRepositoryr.findById(maSanPham);
    }

    @Override
    public Page<SanPham> findByPage(int page) {
        int size = 8;
        PageRequest pageRequest = PageRequest.of(page, size);
        return sanPhamRepositoryr.findAll(pageRequest);
    }

    @Override
    public void save(SanPham sanPham) {
        sanPhamRepositoryr.save(sanPham);
    }

//    @Override
//    public void xoa(UUID id) {
//        sanPhamRepositoryr.deleteById(id);
//    }
}
