package com.example.duanquanaojava5.Model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;

@Entity(name = "GioHang")
@Table(name = "GioHang")
@Data
public class GioHang {
    @Id
    @Column(name="MaGioHang")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maGioHang;

    @Column(name="NgayTao")
    private Date ngayTao;

    @Column(name="TrangThai")
    private Integer trangThai;

    @ManyToOne
    @JoinColumn(name="KhachHang")
    private KhachHang khachHang;
}
