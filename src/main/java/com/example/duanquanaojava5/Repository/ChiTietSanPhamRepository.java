package com.example.duanquanaojava5.Repository;

import com.example.duanquanaojava5.Model.ChiTietSanPham;
import com.example.duanquanaojava5.Model.MauSac;
import com.example.duanquanaojava5.Model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham, Integer> {
    ChiTietSanPham findBySpMaSanPham(Integer maSanPham);
    ChiTietSanPham findBySpMaSanPhamAndMauSac_MaMauSacAndSz_MaSize(Integer maSanPham, Integer maSize, Integer maMauSac);
    @Query("SELECT DISTINCT ctsp.sz FROM ChiTietSanPham ctsp WHERE ctsp.sp.maSanPham = :maSanPham AND ctsp.mauSac.maMauSac = :maMauSac")
    List<Size> findDistinctSizeByMaSanPhamAndMaMauSac(@Param("maSanPham") Integer maSanPham, @Param("maMauSac") Integer maMauSac);
    @Query("SELECT DISTINCT ctsp.mauSac FROM ChiTietSanPham ctsp WHERE ctsp.sp.maSanPham = :maSanPham AND ctsp.sz.maSize = :maSize")
    List<MauSac> findDistinctMauSacByMaSanPhamAndMaSize(@Param("maSanPham") Integer maSanPham, @Param("maSize") Integer maSize);

    List<ChiTietSanPham> findBySp_MaSanPhamAndSz_MaSize(Integer maSanPham, Integer maSize);
    List<ChiTietSanPham> findBySp_MaSanPhamAndMauSac_MaMauSac(Integer maSanPham, Integer maMauSac);
    ChiTietSanPham findBySp_MaSanPhamAndSz_MaSizeAndMauSac_MaMauSac(Integer maSanPham,Integer maSize, Integer maMauSac);
}
        