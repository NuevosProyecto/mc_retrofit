package com.proyecto.retrofit.service.implement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.proyecto.retrofit.model.Quotation;
import com.proyecto.retrofit.model.QuotationStatusRequest;
import com.proyecto.retrofit.model.QuotationStatusResponse;
import com.proyecto.retrofit.repository.QuotationRepository;
import com.proyecto.retrofit.service.QuotationService;
import java.io.IOException;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
@Slf4j
public class QuotationServiceImpl implements QuotationService {

    public static String baseUrl = "http://localhost:8092";

    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build()).build();

    private QuotationRepository quotationRepository = retrofit.create(QuotationRepository.class);

    public QuotationServiceImpl() {
        Gson gson = new GsonBuilder().setLenient().create();
    }

    @Override
        public Quotation save(Quotation model) throws IOException {
        log.info("consumiendo metodo POST de Mc_Quotation");
        return quotationRepository.save(model).execute().body();
    }

    @Override
    public Quotation update(Quotation model) throws IOException {
        log.info("consumiendo metodo PUT por ID de Mc_Quotation");
        return quotationRepository.update(model).execute().body();
    }

    @Override
    public Quotation getData(Map<String, String> params) throws IOException {
        log.info("consumiendo metodo GET de Mc_Quotation");
        return quotationRepository.getData(params).execute().body();
    }

    @Override
    public QuotationStatusResponse updateStatus(Long id, QuotationStatusRequest status) throws IOException {
        log.info("consumiendo metodo PUT por STATUS  de Mc_Quotation");
            return quotationRepository.updateStatus(id, status).execute().body();
        }

    }
