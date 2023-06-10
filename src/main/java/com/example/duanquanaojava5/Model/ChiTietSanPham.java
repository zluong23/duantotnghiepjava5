package com.example.duanquanaojava5.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Entity(name = "ChiTietSanPham")
@Table(name = "CHITIETSP")
@Data
public class ChiTietSanPham {
    @Id
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "MACTSP")
    private String maCTSP;

    @Column(name = "NGAYTAO")
    private Date ngayTao;

    @Column(name = "NGAYSUA")
    private Date ngaySua;

    @ManyToOne
    @JoinColumn(name = "IDSP")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IDDONGSP")
    private DongSP dongSP;

    @ManyToOne
    @JoinColumn(name = "IDMAUSAC")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "IDSIZE")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "IDNSX")
    private NSX nsx;

    @ManyToOne
    @JoinColumn(name = "IDCHATLIEU")
    private ChatLieu chatLieu;

    @Column(name = "IMG")
    private String img;

    @Column(name = "SOLUONGTON")
    private Integer soLuongTon;

    @Column(name = "GIANHAP")
    private Integer giaNhap;

    @Column(name = "GIABAN")
    private Integer giaBan;

    @Column(name = "MAVACH")
    private String maVach;

    @Column(name = "MOTA")
    private String moTa;



}
