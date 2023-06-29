package com.example.duanquanaojava5.Model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;

@Entity(name = "HoaDon")
@Table(name = "HoaDon")
@Data
public class HoaDon {
    @Id
    @Column(name="MaHoaDon")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maHoaDon;

    @Column(name="NgayTao")
    private Date ngayTao;

    @Column(name="NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name="TrangThai")
    private Integer trangThai;

    @Column(name="GhiChu")
    private String ghiChu;

    @ManyToOne
    @JoinColumn(name="KhachHang")
    private KhachHang khachHang;


}
