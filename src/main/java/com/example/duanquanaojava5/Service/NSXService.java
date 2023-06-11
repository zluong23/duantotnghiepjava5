package com.example.duanquanaojava5.Service;

import com.example.duanquanaojava5.Model.NSX;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public interface NSXService {
    ArrayList<NSX> getAll();
    Optional<NSX> findById(UUID id);
}
