package com.proyecto.retrofit.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuotationItem {

    private Long id;
    private Long idDetail;
    private String description;
    private BigDecimal unitAmount;
    private Integer quantity;

    public BigDecimal getTotalAmount() {
        return unitAmount.multiply(new BigDecimal(quantity));
    }
}
