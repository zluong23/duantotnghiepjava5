package com.example.duanquanaojava5.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "SanPham")
@Table(name = "SANPHAM")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SanPham {
    @Id
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

//    @Column(name = "MASP")
//    private String MASP;

    @Column(name = "TEN")
    private String TEN;
}
