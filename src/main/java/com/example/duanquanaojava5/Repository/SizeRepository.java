package com.example.duanquanaojava5.Repository;

import com.example.duanquanaojava5.Model.MauSac;
import com.example.duanquanaojava5.Model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface SizeRepository extends JpaRepository<Size, Integer> {
    @Query("SELECT DISTINCT sp.sz FROM ChiTietSanPham sp WHERE sp.sp.maSanPham = :maSanPham")
    List<Size> findBymaSanPham(@Param("maSanPham") Integer maSanPham);
}
