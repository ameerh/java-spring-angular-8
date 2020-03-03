package com.reliant.value.test.service;

import com.reliant.value.test.model.Assets;
import com.reliant.value.test.model.Condition;
import com.reliant.value.test.repository.AssetsRepository;
import com.reliant.value.test.repository.ConditionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConditionService {
    private final ConditionRepository conditionRepository;

    public ConditionService(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    public List<Condition> findAll() {
        return conditionRepository.findAll();
    }

    public Optional<Condition> findById(Long id) {
        return conditionRepository.findById(id);
    }

    public Condition save(Condition stock) {
        return conditionRepository.save(stock);
    }

    public void deleteById(Long id) {
        conditionRepository.deleteById(id);
    }
}