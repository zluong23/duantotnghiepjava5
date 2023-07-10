package com.example.duanquanaojava5.Service;

import com.example.duanquanaojava5.Model.ChatLieu;
import com.example.duanquanaojava5.Model.DongSP;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DongSPService {
    ArrayList<DongSP> getAll();
    DongSP findByTenDongSP(String tenDongSP);
    void save(DongSP dongSP);
//    Optional<DongSP> findById(UUID id);
    void delete(Integer maDongSP);
}
