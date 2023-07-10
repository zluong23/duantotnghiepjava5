package com.example.duanquanaojava5.Service.impl;

import com.example.duanquanaojava5.Model.DongSP;
import com.example.duanquanaojava5.Repository.ChiTietSanPhamRepository;
import com.example.duanquanaojava5.Repository.DongSpRepository;
import com.example.duanquanaojava5.Service.DongSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DongSPServiceImpl implements DongSPService {
    @Autowired
    DongSpRepository dspRepo;

    @Override
    public ArrayList<DongSP> getAll() {
        return (ArrayList<DongSP>) dspRepo.findAll();
    }

    @Override
    public DongSP findByTenDongSP(String tenDongSP) {
        return dspRepo.findByTenDongSP(tenDongSP);
    }

    @Override
    public void save(DongSP dongSP) {
        dspRepo.save(dongSP);
    }

    @Override
    public void delete(Integer maDongSP) {
        dspRepo.deleteById(maDongSP);
    }
//
//    @Override
//    public Optional<DongSP> findById(UUID id) {
//        return dspRepo.findById(id);
//    }
}
