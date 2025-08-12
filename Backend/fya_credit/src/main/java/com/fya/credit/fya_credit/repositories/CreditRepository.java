package com.fya.credit.fya_credit.repositories;

import com.fya.credit.fya_credit.models.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long>
{

    List<Credit> findCreditByNombreClienteContainingIgnoreCase(String nombre);
    List<Credit> findCreditByComercialContainingIgnoreCase(String comercial);
    List<Credit> findCreditByNumeroDocumento(Long numeroDocumento);
}
