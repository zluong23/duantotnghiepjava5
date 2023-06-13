package com.example.duanquanaojava5.Repository;

import com.example.duanquanaojava5.Model.ChiTietSanPham;
import com.example.duanquanaojava5.Model.GioHang;
import com.example.duanquanaojava5.Model.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet,Integer> {
    List<GioHangChiTiet> findByGioHangMaGioHang(Integer maGioHang);
    List<GioHangChiTiet>  findByGioHangAndAndCtsp(GioHang gioHang, ChiTietSanPham chiTietSanPham);
}
