package com.kiit.supplychain.p2p_backend.controller;

import com.kiit.supplychain.p2p_backend.model.Material;
import com.kiit.supplychain.p2p_backend.model.PurchaseRequisition;
import com.kiit.supplychain.p2p_backend.repository.MaterialRepository;
import com.kiit.supplychain.p2p_backend.repository.PurchaseRequisitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin(origins = "*")
public class InventoryController {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private PurchaseRequisitionRepository prRepository;

    @GetMapping("/materials")
    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    @GetMapping("/low-stock")
    public List<Material> getLowStockMaterials() {
        return materialRepository.findByCurrentStockLessThanEqual(50);
    }

    @PostMapping("/requisition")
    public ResponseEntity<PurchaseRequisition> createRequisition(@RequestBody PurchaseRequisition requisition) {
        requisition.setStatus("PENDING_APPROVAL");
        PurchaseRequisition savedReq = prRepository.save(requisition);
        return ResponseEntity.ok(savedReq);
    }
}