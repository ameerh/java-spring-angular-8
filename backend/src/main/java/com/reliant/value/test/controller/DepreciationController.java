package com.reliant.value.test.controller;

import com.reliant.value.test.exception.ResourceNotFoundException;
import com.reliant.value.test.model.Assets;
import com.reliant.value.test.model.Depreciation;
import com.reliant.value.test.service.AssetsService;
import com.reliant.value.test.service.DepreciationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/depreciation")
public class DepreciationController {
    @Autowired
    private final DepreciationService depreciationService;

    public DepreciationController(DepreciationService depreciationService) {
        this.depreciationService = depreciationService;
    }

    @GetMapping
    public List<Depreciation> getAllDepreciation() {
        return depreciationService.findAll();
    }
}