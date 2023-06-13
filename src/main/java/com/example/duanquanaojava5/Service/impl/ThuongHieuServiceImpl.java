package com.example.duanquanaojava5.Service.impl;

import com.example.duanquanaojava5.Model.ThuongHieu;
import com.example.duanquanaojava5.Repository.ThuongHieuRepository;
import com.example.duanquanaojava5.Service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService {
    @Autowired
    ThuongHieuRepository thuongHieuRepository;
    @Override
    public ThuongHieu findByTenThuongHieu(String tenThuongHieu) {
        return thuongHieuRepository.findByTenThuongHieu(tenThuongHieu);
    }

    @Override
    public void save(ThuongHieu thuongHieu) {
        thuongHieuRepository.save(thuongHieu);
    }
}
