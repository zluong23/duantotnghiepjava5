package com.example.duanquanaojava5.Service;

import com.example.duanquanaojava5.Model.ThuongHieu;

public interface ThuongHieuService {
    ThuongHieu findByTenThuongHieu(String tenThuongHieu);
    void save(ThuongHieu thuongHieu);
}
