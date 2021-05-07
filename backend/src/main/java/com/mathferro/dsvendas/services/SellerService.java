package com.mathferro.dsvendas.services;

import com.mathferro.dsvendas.dto.SellerDTO;
import com.mathferro.dsvendas.entities.Seller;
import com.mathferro.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired // Injetar essa dependência de forma transparente ( ao inves de = new SellerRe...)
    private SellerRepository repository;

    public List<SellerDTO> findAll() {
        List<Seller> result = repository.findAll();
        //return result.stream().map(SellerDTO::new).collect(Collectors.toList());
        return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
    }
}
