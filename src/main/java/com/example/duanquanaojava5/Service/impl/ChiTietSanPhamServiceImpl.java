package com.example.duanquanaojava5.Service.impl;

import com.example.duanquanaojava5.Model.ChiTietSanPham;
import com.example.duanquanaojava5.Repository.ChiTietSanPhamRepository;
import com.example.duanquanaojava5.Service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {
    @Autowired
    ChiTietSanPhamRepository ctspRepo;

    @Override
    public ArrayList<ChiTietSanPham> getAll() {
        return (ArrayList<ChiTietSanPham>) ctspRepo.findAll();
    }

    @Override
    public Optional<ChiTietSanPham> findById(UUID id) {
        return ctspRepo.findById(id);
    }

    @Override
    public void save(ChiTietSanPham ctsp) {
        ctspRepo.save(ctsp);
    }
}
