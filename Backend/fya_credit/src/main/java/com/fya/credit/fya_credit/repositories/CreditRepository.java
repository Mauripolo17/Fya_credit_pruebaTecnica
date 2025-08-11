package com.fya.credit.fya_credit.repositories;

import com.fya.credit.fya_credit.models.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long>
{
}
