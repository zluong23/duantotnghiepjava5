package com.example.duanquanaojava5.Service.impl;

import com.example.duanquanaojava5.Model.MauSac;
import com.example.duanquanaojava5.Repository.MauSacRepository;
import com.example.duanquanaojava5.Service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    MauSacRepository msRepo;

    @Override
    public ArrayList<MauSac> getAll() {
        return (ArrayList<MauSac>) msRepo.findAll();
    }

    @Override
    public Optional<MauSac> findById(UUID id) {
        return msRepo.findById(id);
    }
}
