package com.reliant.value.test.service;

import com.reliant.value.test.model.Assets;
import com.reliant.value.test.model.Depreciation;
import com.reliant.value.test.repository.AssetsRepository;
import com.reliant.value.test.repository.DepreciationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepreciationService {
    private final DepreciationRepository depreciationRepository;

    public DepreciationService(DepreciationRepository depreciationRepository) {
        this.depreciationRepository = depreciationRepository;
    }

    public List<Depreciation> findAll() {
        return depreciationRepository.findAll();
    }

    public Optional<Depreciation> findById(Long id) {
        return depreciationRepository.findById(id);
    }

    public Depreciation save(Depreciation stock) {
        return depreciationRepository.save(stock);
    }

    public void deleteById(Long id) {
        depreciationRepository.deleteById(id);
    }
}