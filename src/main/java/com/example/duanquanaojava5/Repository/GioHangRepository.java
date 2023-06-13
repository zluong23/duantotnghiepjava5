package com.example.duanquanaojava5.Repository;

import com.example.duanquanaojava5.Model.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang,Integer> {
    GioHang findByKhachHangMaKhachHang(Integer maKhachHang);
}
