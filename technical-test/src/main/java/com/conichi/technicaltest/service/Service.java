package com.conichi.technicaltest.service;

import com.cloudmersive.client.invoker.ApiException;
import com.cloudmersive.client.model.VatLookupResponse;
import com.conichi.technicaltest.client.Client;
import com.conichi.technicaltest.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class Service {

    private Client client;

    @Autowired
    public Service(Client client) {
        this.client = client;
    }

    public CurrencyResponse getConvertedCurrency(Double amount, String source, String target) throws IOException {
        String result = String.format("%1$,.2f", getCurrencyResult(amount, source, target)) +
                String.format(" %s (%s)", target, EnumCurrency.valueOf(target).getName());
        return new CurrencyResponse()
                .setResult(result)
                .setLocalDateTime(LocalDateTime.now(ZoneId.systemDefault()))
                .setTimeZone(ZoneId.systemDefault())
                .setEnumCurrency(EnumCurrency.ignoreCase(source));
    }

    public CurrencyResponse getConvertedCurrency(EnumCurrency currency) {
        try {
            return getConvertedCurrency(1D, currency.name(), EnumCurrency.USD.name());
        } catch (Exception ignore) {
            return null;
        }
    }

    public CurrencyResponse getConvertedCurrency(CurrencyRequest request) throws Exception {
        EnumCurrency source = EnumCurrency.ignoreCase(request.getSource());
        EnumCurrency target = EnumCurrency.ignoreCase(request.getTarget());
        Double result = getCurrencyResult(request.getAmount(), source.name(), target.name());

        return new CurrencyResponse()
                .setResult(String.format("%1$,.2f", result) + String.format(" %s (%s)", request.getTarget(), target.getName()))
                .setLocalDateTime(LocalDateTime.now(ZoneId.systemDefault()))
                .setTimeZone(ZoneId.systemDefault())
                .setEnumCurrency(source);
    }

    private Double getCurrencyResult(Double amount, String source, String target) throws IOException {
        return Double.valueOf(client.getCurrency(amount, source, target).get("result").toString());
    }

    public CountryCode getCountryCode(VatCode vatCode) throws Exception {
        try {
            VatLookupResponse response = client.vatRequest(vatCode);
            return new CountryCode() {{
                setCountryCode(response.getCountryCode());
                setIsValid(response.isIsValid());
            }};
        } catch (ApiException e) {
            throw new Exception("Exception when calling VatApi#vatVatLookup");
        }
    }


}
