package com.proyecto.retrofit.repository;

import java.util.Map;
import com.proyecto.retrofit.model.Quotation;
import com.proyecto.retrofit.model.QuotationStatusRequest;
import com.proyecto.retrofit.model.QuotationStatusResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface QuotationRepository {

    @POST("/quotes")
    Call<Quotation> save(@Body Quotation model);

    @PUT("/quotes/{id}")
    Call<Quotation> update(@Body Quotation model);

    @GET("/quotes")
    Call<Quotation> getData(@PartMap Map<String, String> params);

    @PUT("/quotes/status/{id}")
    Call<QuotationStatusResponse> updateStatus(@Path("id") Long id, @Body QuotationStatusRequest status);

}
