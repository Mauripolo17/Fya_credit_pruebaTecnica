package com.fya.credit.fya_credit.services;

import com.fya.credit.fya_credit.controller.dto.CreditDto;

import java.util.List;

public interface CreditService {
    CreditDto createCredit(CreditDto creditDto);

    CreditDto getCredit(Long id);

    List<CreditDto> getCredits();
}
