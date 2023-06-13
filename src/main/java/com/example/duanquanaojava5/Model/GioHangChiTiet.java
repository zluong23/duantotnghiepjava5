package com.example.duanquanaojava5.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "GioHangChiTiet")
@Table(name = "GioHangChiTiet")
@Data
public class GioHangChiTiet {
    @Id
    @Column(name="MaGioHang")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maGioHang;


    @ManyToOne
    @JoinColumn(name="GioHang")
    private GioHang gioHang;

    @ManyToOne
    @JoinColumn(name="SanPham")
    private ChiTietSanPham ctsp;

    @Column(name="SoLuong")
    private Integer soLuong;

    @Column(name="TrangThai")
    private Integer trangThai;
}
