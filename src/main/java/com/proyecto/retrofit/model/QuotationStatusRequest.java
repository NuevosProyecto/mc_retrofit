package com.proyecto.retrofit.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Model QuotationStatusRequest")
public class QuotationStatusRequest {
    @ApiModelProperty(value = "status")
    private QuotationStatus status;

}
