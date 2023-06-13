package com.example.duanquanaojava5.Repository;

import com.example.duanquanaojava5.Model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang,Integer> {
    KhachHang findByMaKhachHangAndMatKhau(Integer maKhachHang, String matKhau);
}
