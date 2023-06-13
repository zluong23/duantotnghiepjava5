package com.example.duanquanaojava5.Service;

import com.example.duanquanaojava5.Model.SanPham;
import com.example.duanquanaojava5.Model.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SizeService {
    ArrayList<Size> getAll();
    Optional<Size> findById(Integer maSize);
}
