package com.example.duanquanaojava5.Service.impl;

import com.example.duanquanaojava5.Model.NSX;
import com.example.duanquanaojava5.Repository.NSXRepository;
import com.example.duanquanaojava5.Service.NSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class NSXServiceImpl implements NSXService {
    @Autowired
    NSXRepository nsxRepository;
    @Override
    public ArrayList<NSX> getAll() {
        return (ArrayList<NSX>) nsxRepository.findAll();
    }

    @Override
    public Optional<NSX> findById(UUID id) {
        return nsxRepository.findById(id);
    }
}
