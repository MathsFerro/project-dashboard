package com.mathferro.dsvendas.services;

import com.mathferro.dsvendas.dto.SaleDTO;
import com.mathferro.dsvendas.dto.SaleSuccessDTO;
import com.mathferro.dsvendas.dto.SaleSumDTO;
import com.mathferro.dsvendas.dto.SellerDTO;
import com.mathferro.dsvendas.entities.Sale;
import com.mathferro.dsvendas.entities.Seller;
import com.mathferro.dsvendas.repositories.SaleRepository;
import com.mathferro.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true) // Não fazer lock de escrita
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll(); // Trazendo para memória os vendedores para evitar repetição de query, JPA vai armazenar em cache
        Page<Sale> result = repository.findAll(pageable);
        return result.map(SaleDTO::new);
    }

    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupedBySeller() {
        return repository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> successGroupedBySeller() {
        return repository.successGroupedBySeller();
    }
}
