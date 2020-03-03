package com.reliant.value.test.controller;
import com.reliant.value.test.exception.ResourceNotFoundException;
import com.reliant.value.test.service.AssetsService;
import com.reliant.value.test.model.Assets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/assets")
public class AssetsController {
    @Autowired
    private final AssetsService assetsService;

    public AssetsController(AssetsService assetsService) {
        this.assetsService = assetsService;
    }

    @GetMapping
    public List<Assets> getAllAssets() {
        return assetsService.findAll();
    }

    @PostMapping
    public Assets createAsset(@Valid @RequestBody Assets asset) {
        return assetsService.save(asset);
    }

    @GetMapping("/{id}")
    public Assets getAssetById(@PathVariable(value = "id") Long assetId) {
        return assetsService.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset", "id", assetId));
    }

    @PutMapping("/{id}")
    public Assets updateAsset(@PathVariable(value = "id") Long assetId,
                           @Valid @RequestBody Assets assetDetails) {

        Assets asset = assetsService.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset", "id", assetId));

        asset.setNum(assetDetails.getNum());
        asset.setDepreciationCode(assetDetails.getDepreciationCode());
        asset.setLifeYears(assetDetails.getLifeYears());
//        asset.setNum(assetDetails.getNum());
//        asset.setNum(assetDetails.getNum());
//        asset.setNum(assetDetails.getNum());
//        note.setContent(assetDetails.getContent());
        //TODO

        Assets updatedAsset = assetsService.save(asset);
        return updatedAsset;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAsset(@PathVariable(value = "id") Long assetId) {
        Assets asset = assetsService.findById(assetId)
                .orElseThrow(() -> new ResourceNotFoundException("Asset", "id", assetId));

        assetsService.deleteById(assetId);

        return ResponseEntity.ok().build();
    }
}