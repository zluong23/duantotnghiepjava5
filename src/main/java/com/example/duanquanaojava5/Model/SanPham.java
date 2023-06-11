package com.example.duanquanaojava5.Model;

import jakarta.persistence.*;
import lombok.*;

<<<<<<< HEAD
import java.sql.Date;
=======
>>>>>>> origin/master
import java.util.UUID;

@Entity(name = "SanPham")
@Table(name = "SANPHAM")
<<<<<<< HEAD
@Data
=======
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
>>>>>>> origin/master
public class SanPham {
    @Id
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

<<<<<<< HEAD
    @Column(name = "MASP")
    private String maSP;

    @Column(name = "TEN")
    private String ten;

    @Column(name = "NGAYTAO")
    private Date ngayTao;

    @Column(name = "NGAYSUA")
    private Date ngaySua;
=======
//    @Column(name = "MASP")
//    private String MASP;

    @Column(name = "TEN")
    private String TEN;
>>>>>>> origin/master
}
