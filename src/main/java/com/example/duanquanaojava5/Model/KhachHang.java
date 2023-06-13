package com.example.duanquanaojava5.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity(name = "KhachHang")
@Table(name = "KhachHang")
@Data
public class KhachHang {
    @Id
    @Column(name = "MaKhachHang", unique = true, nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maKhachHang;

    @Column(name="TenKhachHang")
    private String tenKhachHang;

    @Column(name="NgaySinh")
    private Date ngaySinh;
    @Column(name="SoDienThoai")
    private String soDienThoai;

    @Column(name="DiaChi")
    private String diaChi;

    @Column(name="Email")
    private String email;

    @Column(name="GioiTinh")
    private Integer gioiTinh;

    @Column(name="MatKhau")
    private String matKhau;
}
