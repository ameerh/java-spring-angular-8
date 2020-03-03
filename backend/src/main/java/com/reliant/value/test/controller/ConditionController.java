package com.reliant.value.test.controller;

import com.reliant.value.test.exception.ResourceNotFoundException;
import com.reliant.value.test.model.Assets;
import com.reliant.value.test.model.Condition;
import com.reliant.value.test.service.AssetsService;
import com.reliant.value.test.service.ConditionService;
import com.reliant.value.test.service.DepreciationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/conditions")
public class ConditionController {
    @Autowired
    private final ConditionService conditionService;

    public ConditionController(ConditionService conditionService) {
        this.conditionService = conditionService;
    }

    @GetMapping
    public List<Condition> getAllConditions() {
        return conditionService.findAll();
    }
}