package com.proyecto.retrofit.controller;

import java.io.IOException;
import java.util.Map;
import com.proyecto.retrofit.model.Quotation;
import com.proyecto.retrofit.model.QuotationStatusRequest;
import com.proyecto.retrofit.model.QuotationStatusResponse;
import com.proyecto.retrofit.service.QuotationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/retrofit/quotes")
@Slf4j
public class QuotationController {

    @Autowired
    private QuotationService quotationService;

    @PostMapping
    public Quotation save(@RequestBody Quotation model) throws IOException {
        log.info("Envio de parametros");
        return quotationService.save(model);
    }

    @PutMapping("/{id}")
    public Quotation update(@RequestBody Quotation model) throws IOException {
        log.info("Actualizacion de parametros");
        return quotationService.update(model);
    }

    @GetMapping
    public Quotation getData(@RequestParam Map<String, String> params) throws IOException {
        log.info("Obtener Data");
        return quotationService.getData(params);
    }

    @PutMapping("/status/{id}")
    public QuotationStatusResponse updateStatus(@PathVariable("id") Long id, @RequestBody QuotationStatusRequest status) throws IOException {
        log.info("Actualizacion status de la Cotizacion");
        return quotationService.updateStatus(id, status);
    }

}
