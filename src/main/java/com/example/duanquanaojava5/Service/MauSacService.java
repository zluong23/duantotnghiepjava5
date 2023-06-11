package com.example.duanquanaojava5.Service;

import com.example.duanquanaojava5.Model.ChatLieu;
import com.example.duanquanaojava5.Model.MauSac;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MauSacService {
    ArrayList<MauSac> getAll();
    Optional<MauSac> findById(UUID id);
}
