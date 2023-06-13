package com.example.duanquanaojava5.Repository;

import com.example.duanquanaojava5.Model.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface MauSacRepository extends JpaRepository<MauSac, Integer> {
    @Query("SELECT DISTINCT sp.mauSac FROM ChiTietSanPham sp WHERE sp.sp.maSanPham = :maSanPham")
    List<MauSac> findBymaSanPham(@Param("maSanPham") Integer maSanPham);
}
