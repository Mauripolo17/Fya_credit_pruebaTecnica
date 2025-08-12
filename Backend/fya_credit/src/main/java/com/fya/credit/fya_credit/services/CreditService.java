package com.fya.credit.fya_credit.services;

import com.fya.credit.fya_credit.controller.dto.CreditDto;

import java.util.List;

public interface CreditService {
    CreditDto createCredit(CreditDto creditDto);
    CreditDto getCredit(Long id);
    List<CreditDto> getCredits();
    List<CreditDto> getCreditsByClientId(Long clientId);
    List<CreditDto> getCreditsByComercial(String comercial);
    List<CreditDto> getCreditsByCliente(String client);
}
