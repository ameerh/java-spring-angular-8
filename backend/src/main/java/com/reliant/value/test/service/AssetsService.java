package com.reliant.value.test.service;

import org.springframework.stereotype.Service;
import com.reliant.value.test.repository.AssetsRepository;
import com.reliant.value.test.model.Assets;
import java.util.List;
import java.util.Optional;

@Service
public class AssetsService {
    private final AssetsRepository assetsRepository;

    public AssetsService(AssetsRepository assetsRepository) {
        this.assetsRepository = assetsRepository;
    }

    public List<Assets> findAll() {
        return assetsRepository.findAll();
    }

    public Optional<Assets> findById(Long id) {
        return assetsRepository.findById(id);
    }

    public Assets save(Assets stock) {
        return assetsRepository.save(stock);
    }

    public void deleteById(Long id) {
        assetsRepository.deleteById(id);
    }
}