package com.proyecto.retrofit.service;

import com.proyecto.retrofit.model.Quotation;
import com.proyecto.retrofit.model.QuotationStatusRequest;
import com.proyecto.retrofit.model.QuotationStatusResponse;
import java.io.IOException;
import java.util.Map;

public interface QuotationService {

    Quotation save(Quotation model) throws IOException;

    Quotation update(Quotation model) throws IOException;

    Quotation getData(Map<String, String> params) throws IOException;

    QuotationStatusResponse updateStatus(Long id, QuotationStatusRequest status) throws IOException;

}
