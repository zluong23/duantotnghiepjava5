package com.example.duanquanaojava5.Service.impl;

import com.example.duanquanaojava5.Model.HoaDon;
import com.example.duanquanaojava5.Repository.HoaDonRepository;
import com.example.duanquanaojava5.Service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    HoaDonRepository hoaDonRepository;
    @Override
    public ArrayList<HoaDon> getAll() {
        return (ArrayList<HoaDon>) hoaDonRepository.findAll();
    }

    @Override
    public Optional<HoaDon> findById(Integer maHoaDon) {
        return hoaDonRepository.findById(maHoaDon);
    }

    @Override
    public void save(HoaDon hoaDon) {
        hoaDonRepository.save(hoaDon);
    }
}
