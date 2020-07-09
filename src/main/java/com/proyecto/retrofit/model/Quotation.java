package com.proyecto.retrofit.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Quotation {

    private Long id;
    private String numberQuotation;
    private String client;
    private String dateQuotation;
    private QuotationStatus status;
    private List<QuotationItem> items;

    public BigDecimal getTotalAmount() {
        BigDecimal total = new BigDecimal(0.0).setScale(2);
        for (QuotationItem item : items) {
            total = total.add(item.getTotalAmount().setScale(2));
        }
        return total;
    }
}
