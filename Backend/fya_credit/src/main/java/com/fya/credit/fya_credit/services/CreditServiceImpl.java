package com.fya.credit.fya_credit.services;

import com.fya.credit.fya_credit.controller.dto.CreditDto;
import com.fya.credit.fya_credit.controller.dto.CreditMapper;
import com.fya.credit.fya_credit.exceptions.CreditNotFoundException;
import com.fya.credit.fya_credit.models.Credit;
import com.fya.credit.fya_credit.models.CreditCreatedEvent;
import com.fya.credit.fya_credit.repositories.CreditRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;
    private final CreditMapper creditMapper;
    private final ApplicationEventPublisher eventPublisher;

    public CreditServiceImpl(CreditRepository creditRepository, CreditMapper creditMapper, ApplicationEventPublisher eventPublisher) {
        this.creditRepository = creditRepository;
        this.creditMapper = creditMapper;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public CreditDto createCredit(CreditDto creditDto) {
        Credit credit = creditMapper.toCredit(creditDto);
        if(creditDto.fechaDeRegistro()==null){
            credit.setFechaDeRegistro(LocalDate.now());
        }
        Credit savedCredit = creditRepository.save(credit);
        
        eventPublisher.publishEvent(new CreditCreatedEvent(
                savedCredit.getNombreCliente(),
                savedCredit.getValorCredito(),
                savedCredit.getComercial(),
                savedCredit.getFechaDeRegistro()
        ));

        return creditMapper.toCreditDto(savedCredit);
    }

    @Override
    public CreditDto getCredit(Long id) {
        return  creditRepository.findById(id).map(
            credit -> creditMapper.toCreditDto(credit)
        ).orElseThrow(()-> new CreditNotFoundException("El credit no fue encontrado"));
    }

    @Override
    public List<CreditDto> getCredits() {
        return creditRepository.findAll().stream().map(creditMapper::toCreditDto).collect(Collectors.toList());
    }

    @Override
    public List<CreditDto> getCreditsByClientId(Long clientId) {
        return creditRepository.findCreditByNumeroDocumento(clientId).stream().map(creditMapper::toCreditDto).collect(Collectors.toList());
    }

    @Override
    public List<CreditDto> getCreditsByComercial(String comercial) {
        return creditRepository.findCreditByComercialContainingIgnoreCase(comercial).stream().map(creditMapper::toCreditDto).collect(Collectors.toList());
    }

    @Override
    public List<CreditDto> getCreditsByCliente(String client) {
        return creditRepository.findCreditByNombreClienteContainingIgnoreCase(client).stream().map(creditMapper::toCreditDto).collect(Collectors.toList());
    }
}
