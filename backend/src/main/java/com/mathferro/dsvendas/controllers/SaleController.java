package com.mathferro.dsvendas.controllers;

import com.mathferro.dsvendas.dto.SaleDTO;
import com.mathferro.dsvendas.dto.SaleSuccessDTO;
import com.mathferro.dsvendas.dto.SaleSumDTO;
import com.mathferro.dsvendas.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
        Page<SaleDTO> result = service.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/amount-by-seller")
    public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
        List<SaleSumDTO> result = service.amountGroupedBySeller();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/success-by-seller")
    public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller() {
        List<SaleSuccessDTO> result = service.successGroupedBySeller();
        return ResponseEntity.ok(result);
    }
}
