package com.example.duanquanaojava5.Service;

import com.example.duanquanaojava5.Model.HoaDon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

public interface HoaDonService {
    ArrayList<HoaDon> getAll();
    Optional<HoaDon> findById(Integer maHoaDon);
    void save(HoaDon hoaDon);
}
