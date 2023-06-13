package com.example.duanquanaojava5.Service.impl;

import com.example.duanquanaojava5.Model.ChiTietSanPham;
import com.example.duanquanaojava5.Model.MauSac;
import com.example.duanquanaojava5.Model.Size;
import com.example.duanquanaojava5.Repository.ChiTietSanPhamRepository;
import com.example.duanquanaojava5.Repository.MauSacRepository;
import com.example.duanquanaojava5.Repository.SizeRepository;
import com.example.duanquanaojava5.Service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {
    @Autowired
    ChiTietSanPhamRepository ctspRepo;
    @Autowired
    MauSacRepository mauSacRepository;
    @Autowired
    SizeRepository sizeRepository;

    @Override
    public ArrayList<ChiTietSanPham> getAll() {
        return (ArrayList<ChiTietSanPham>) ctspRepo.findAll();
    }

    @Override
    public Optional<ChiTietSanPham> findById(Integer id) {
        return ctspRepo.findById(id);
    }

    @Override
    public void save(ChiTietSanPham ctsp) {
        ctspRepo.save(ctsp);
    }

    @Override
    public Page<ChiTietSanPham> findByPage(int page) {
        return ctspRepo.findAll(PageRequest.of(page,8));
    }

    @Override
    public List<MauSac> findMauSacBymaSanPham(Integer maSanPham) {
        return mauSacRepository.findBymaSanPham(maSanPham);
    }

    @Override
    public List<Size> findSizeBymaSanPham(Integer maSanPham) {
        return sizeRepository.findBymaSanPham(maSanPham);
    }

    @Override
    public List<Size> findSizeBymaSanPhamAndMaMauSac(Integer maSanPham, Integer maMauSac) {
        return ctspRepo.findDistinctSizeByMaSanPhamAndMaMauSac(maSanPham,maMauSac);
    }

    @Override
    public List<MauSac> findMauSacBymaSanPhamAndMaSize(Integer maSanPham, Integer maSize) {
        return ctspRepo.findDistinctMauSacByMaSanPhamAndMaSize(maSanPham,maSize);
    }

    @Override
    public ChiTietSanPham findBySpMaSanPham(Integer maSanPham) {
        return ctspRepo.findBySpMaSanPham(maSanPham);
    }

    @Override
    public List<ChiTietSanPham> getChiTietSanPhamByMaSanPhamAndMaSize(Integer maSanPham, Integer maSize) {
        return ctspRepo.findBySp_MaSanPhamAndSz_MaSize(maSanPham,maSize);
    }

    @Override
    public List<ChiTietSanPham> getChiTietSanPhamByMaSanPhamAndMaMauSac(Integer maSanPham, Integer maMauSac) {
        return ctspRepo.findBySp_MaSanPhamAndMauSac_MaMauSac(maSanPham,maMauSac);
    }

    @Override
    public ChiTietSanPham getChiTietSanPhamByMaSanPhamAndMaSizeAndMaMauSac(Integer maSanPham, Integer maSize, Integer maMauSac) {
        return ctspRepo.findBySp_MaSanPhamAndSz_MaSizeAndMauSac_MaMauSac(maSanPham,maSize,maMauSac);
    }


}
