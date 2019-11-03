package com.conichi.technicaltest.client;

import com.cloudmersive.client.VatApi;
import com.cloudmersive.client.invoker.ApiException;
import com.cloudmersive.client.model.VatLookupRequest;
import com.cloudmersive.client.model.VatLookupResponse;
import com.conichi.technicaltest.model.VatCode;
import com.conichi.technicaltest.utility.Utility;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

@Component
public class Client {

    private RestTemplate rest;
    private Utility utility;
    @Value("${spring.application.currency_key}")
    private String ACCESS_KEY;
    @Value("${spring.application.api_layer_url}")
    private String APILAYER_NET_API;
    @Value("${spring.application.currency_func}")
    private String CONVERT;

    public Client(Utility utility) {
        this.rest = new RestTemplate();
        this.utility = utility;
    }

    private String restGetRequest(UriComponentsBuilder builder) {
        return this.rest.exchange(RequestEntity
                .method(HttpMethod.GET, builder.build(false).toUri())
                .accept(MediaType.APPLICATION_JSON).body(null), new ParameterizedTypeReference<String>() {
        }).getBody();
    }

    public Map<String, Object> getCurrency(Double amount, String sourceCurrency, String targetCurrency) throws IOException {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUri(URI.create(APILAYER_NET_API + CONVERT + ACCESS_KEY));
        java.net.URLEncoder
                .encode(utility.addBuilderParam(builder, sourceCurrency, targetCurrency, amount).toUriString(), "UTF-8");
        return utility.jsonReader(restGetRequest(builder));
    }

    public VatLookupResponse vatRequest(VatCode vatCode) throws ApiException {
        return new VatApi().vatVatLookup(new VatLookupRequest().vatCode(vatCode.getVatCode()));
    }

}
