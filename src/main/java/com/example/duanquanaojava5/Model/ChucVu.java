package com.example.duanquanaojava5.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Entity(name = "ChucVu")
@Table(name = "CHUCVU")
@Data
public class ChucVu {
    @Id
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "MACHUCVU")
    private String maChucVu;

    @Column(name = "TEN")
    private String ten;

    @Column(name = "NGAYTAO")
    private Date ngayTao;

    @Column(name = "NGAYSUA")
    private Date ngaySua;
}
