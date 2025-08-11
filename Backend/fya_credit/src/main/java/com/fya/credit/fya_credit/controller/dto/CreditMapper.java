package com.fya.credit.fya_credit.controller.dto;

import com.fya.credit.fya_credit.models.Credit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditMapper {
    Credit toCredit(CreditDto creditDto);
    CreditDto toCreditDto(Credit credit);
}
