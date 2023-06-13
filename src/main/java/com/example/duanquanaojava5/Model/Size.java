package com.example.duanquanaojava5.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Entity(name = "Size")
@Table(name = "SIZE")
@Data
public class Size {
    @Id
    @Column(name = "MaSize", unique = true, nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maSize;


    @Column(name = "SoSize")
    private String soSize;

    @Column(name = "ChieuCao")
    private String chieuCao;

    @Column(name = "CanNang")
    private String CanNang;
}
