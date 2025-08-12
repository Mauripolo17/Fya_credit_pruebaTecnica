package com.fya.credit.fya_credit.controller;

import com.fya.credit.fya_credit.controller.dto.CreditDto;
import com.fya.credit.fya_credit.services.CreditService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/credit")
@CrossOrigin("*")
public class CreditController {

    private final CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping("/clienteId/{id}")
    public ResponseEntity<CreditDto> getCreditByIdCliente(@PathVariable("id") Long id) {
        return ResponseEntity.ok(creditService.getCredit(id));
    }

    @GetMapping("/client/{cliente}")
    public ResponseEntity<List<CreditDto>> getCreditByClient(@PathVariable("cliente") String cliente) {
        return ResponseEntity.ok(creditService.getCreditsByCliente(cliente));
    }

    @GetMapping("/comercial/{comercial}")
    public ResponseEntity<List<CreditDto>> getCreditByComercial(@PathVariable("comercial") String comercial) {
        return ResponseEntity.ok(creditService.getCreditsByComercial(comercial));
    }

    @GetMapping
    public ResponseEntity<List<CreditDto>> getCredits() {
        return ResponseEntity.ok(creditService.getCredits());
    }

    @PostMapping
    public ResponseEntity<CreditDto> createCredit(@Valid  @RequestBody CreditDto creditDto) {
        CreditDto created = creditService.createCredit(creditDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.id())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }
}
