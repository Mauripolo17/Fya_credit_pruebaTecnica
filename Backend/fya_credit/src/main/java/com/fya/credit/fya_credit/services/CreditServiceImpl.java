package com.fya.credit.fya_credit.services;

import com.fya.credit.fya_credit.controller.dto.CreditDto;
import com.fya.credit.fya_credit.controller.dto.CreditMapper;
import com.fya.credit.fya_credit.models.Credit;
import com.fya.credit.fya_credit.repositories.CreditRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;
    private final CreditMapper creditMapper;

    public CreditServiceImpl(CreditRepository creditRepository, CreditMapper creditMapper) {
        this.creditRepository = creditRepository;
        this.creditMapper = creditMapper;
    }

    @Override
    public CreditDto createCredit(CreditDto creditDto) {
        Credit credit = creditMapper.toCredit(creditDto);
        credit.setFechaDeRegistro(LocalDate.now());
        return creditMapper.toCreditDto(creditRepository.save(credit));
    }

    @Override
    public CreditDto getCredit(Long id) {
        Optional<Credit> credito  = creditRepository.findById(id);
        if (credito.isPresent()) {
            return creditMapper.toCreditDto(credito.get());
        }
        return null;
    }

    @Override
    public List<CreditDto> getCredits() {
        return creditRepository.findAll().stream().map(creditMapper::toCreditDto).collect(Collectors.toList());
    }
}
