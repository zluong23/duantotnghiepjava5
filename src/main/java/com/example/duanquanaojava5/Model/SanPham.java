package com.example.duanquanaojava5.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.UUID;

@Entity(name = "SanPham")
@Table(name = "SANPHAM")
@Data
public class SanPham {
    @Id
    @Column(name = "MaSanPham", unique = true, nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maSanPham;

    @Column(name = "TenSanPham")
    private String tenSanPham;

    @ManyToOne
    @JoinColumn(name = "ThuongHieu")
    private ThuongHieu th;

    @ManyToOne
    @JoinColumn(name = "ChatLieu")
    private ChatLieu cl;

    @ManyToOne
    @JoinColumn(name = "KieuAo")
    private DongSP dsp;


    @Column(name = "HinhAnh")
    private String hinhAnh;

    @Column(name = "luotmua")
    private Integer luotMua;

    @Column(name = "GiaNhap")
    private Double giaNhap;

    @Column(name = "GiaBan")
    private Double giaBan;

    @Column(name = "mota")
    private String moTa;
}
