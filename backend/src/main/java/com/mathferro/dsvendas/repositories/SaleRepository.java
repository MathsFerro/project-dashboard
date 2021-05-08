package com.mathferro.dsvendas.repositories;

import com.mathferro.dsvendas.dto.SaleSuccessDTO;
import com.mathferro.dsvendas.dto.SaleSumDTO;
import com.mathferro.dsvendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.mathferro.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) " +
           "FROM Sale AS obj GROUP BY obj.seller") // JPQL
    List<SaleSumDTO> amountGroupedBySeller();

    @Query("SELECT new com.mathferro.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) " +
            "FROM Sale AS obj GROUP BY obj.seller") // JPQL
    List<SaleSuccessDTO> successGroupedBySeller();
}
