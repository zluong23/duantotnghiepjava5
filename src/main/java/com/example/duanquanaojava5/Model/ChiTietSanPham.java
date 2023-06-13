package com.example.duanquanaojava5.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Entity(name = "ChiTietSanPham")
@Table(name = "ChiTietSanPham")
@Data
public class ChiTietSanPham {
    @Id
    @Column(name = "MaCTSP", unique = true, nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maCTSP;


    @ManyToOne
    @JoinColumn(name = "SanPham")
    private SanPham sp;


    @ManyToOne
    @JoinColumn(name = "MauSac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "Size")
    private Size sz;


    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "maVach")
    private String maVach;




}
