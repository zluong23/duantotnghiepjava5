package com.example.duanquanaojava5.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity(name = "HoaDonChiTiet")
@Table(name = "HoaDonChiTiet")
@Data
public class HoaDonChiTiet {
    @Id
    @Column(name = "MaHoaDon")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maHoaDon;

    @ManyToOne
    @JoinColumn(name = "HoaDon")
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "SanPham")
    private ChiTietSanPham sanPham;

    @Column(name = "soLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private Double donGia;

    @Column(name = "TrangThai")
    private Integer trangThai;

}
