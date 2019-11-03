package com.conichi.technicaltest.controller;

import com.conichi.technicaltest.dao.Dao;
import com.conichi.technicaltest.model.*;
import com.conichi.technicaltest.model.entity.Currency;
import com.conichi.technicaltest.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping(value = "/api/")
public class Controller {

    private Service service;
    private Dao dao;
    private final String  ERROR = "You have not specified an amount to be converted. [Example: amount=5]";

    @Autowired
    public Controller(Service service, Dao dao) {
        this.service = service;
        this.dao = dao;
    }

    @RequestMapping(value = "getLocalDateTime", method = RequestMethod.GET)
    public LocDateTime getLocalDateTime() {
        return new LocDateTime()
                .setLocalDateTime(LocalDateTime.now())
                .setTimeZone(ZoneId.systemDefault());
    }

    @RequestMapping(value = "currency/convert", method = RequestMethod.GET)
    public CurrencyResponse currencyConvert(@RequestParam Double amount, @RequestParam EnumCurrency sourceCurrency, @RequestParam EnumCurrency targetCurrency) throws IOException {
        return amount > 0D ?  service.getConvertedCurrency(amount, sourceCurrency.name(), targetCurrency.name()) : new CurrencyResponse().setError(ERROR);
    }

    @RequestMapping(value = "currency/convert", method = RequestMethod.POST)
    public CurrencyResponse currencyConvert(@RequestBody CurrencyRequest currencyRequest) throws Exception {
        return currencyRequest.getAmount()>0 ? service.getConvertedCurrency(currencyRequest) : new CurrencyResponse().setError(ERROR);
    }

    @RequestMapping(value = "validate-vat", method = RequestMethod.POST)
    public CountryCode validateVAT(@RequestBody VatCode vatCode) throws Exception {
        return service.getCountryCode(vatCode);
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public List<Currency> getCurrencies(){
        return dao.getAll();
    }

    @RequestMapping(value = "update-currency-data", method = RequestMethod.PUT)
    public void updateCurrencies(Currency currency){
        dao.update(currency);
    }

    @RequestMapping(value = "delete-currency-data", method = RequestMethod.DELETE)
    public void deleteCurrencies(Long id){
        dao.delete(dao.getById(id));
    }


}
