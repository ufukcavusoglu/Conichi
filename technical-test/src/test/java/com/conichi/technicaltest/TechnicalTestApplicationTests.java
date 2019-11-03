package com.conichi.technicaltest;


import com.cloudmersive.client.invoker.Configuration;
import com.cloudmersive.client.invoker.auth.ApiKeyAuth;
import com.conichi.technicaltest.controller.Controller;
import com.conichi.technicaltest.dao.Dao;
import com.conichi.technicaltest.model.CurrencyRequest;
import com.conichi.technicaltest.model.EnumCurrency;
import com.conichi.technicaltest.model.VatCode;
import com.conichi.technicaltest.model.entity.Currency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TechnicalTestApplicationTests {

    @Autowired
    Controller controller;

    @Autowired
    Dao dao;

    @Test
    public void contextLoads() {
    }

    public TechnicalTestApplicationTests() {
        ApiKeyAuth apiKey = (ApiKeyAuth) Configuration.getDefaultApiClient().getAuthentication("Apikey");
        apiKey.setApiKey("43c75c05-2750-4ed3-ad7c-774307face42");
    }

    @Test
    public void test1() {
        Currency currency = new Currency();
        currency.setTimeZone(ZoneId.systemDefault());
        currency.setResult("1234567890-=!@#$%^&*()_+{}[]:;'?.,,.//asqwerty");
        currency.setLocalDateTime(LocalDateTime.now());
        currency.setCurrency(EnumCurrency.JPY);
        System.out.println(dao.save(currency));
    }

    @Test
    public void test2() {
        System.out.println(controller.getLocalDateTime().getLocalDateTime());
    }

    @Test
    public void test3() {
        System.out.println(controller.getLocalDateTime());
    }

    @Test
    public void test4() throws Exception {
        System.out.println(controller.validateVAT(new VatCode().setVatCode("GB223462237")).getCountryCode());
    }

    @Test
    public void test5() throws Exception {
        System.out.println(controller.validateVAT(new VatCode().setVatCode("GB223462238")).getCountryCode());
    }

    @Test
    public void test6() throws Exception {
        System.out.println(controller.validateVAT(new VatCode().setVatCode("GB223462239")).getCountryCode());
    }

    @Test
    public void test7() throws Exception {
        System.out.println(controller.validateVAT(new VatCode().setVatCode("FR223462239")).getCountryCode());
    }

    @Test
    public void test8() throws IOException {
        System.out.println(controller.currencyConvert(10D, EnumCurrency.USD, EnumCurrency.USD).toString());
    }

    @Test
    public void test9() throws IOException {
        System.out.println(controller.currencyConvert(10D, EnumCurrency.USD, EnumCurrency.EUR).toString());
    }

    @Test
    public void test10() throws IOException {
        System.out.println(controller.currencyConvert(10D, EnumCurrency.JPY, EnumCurrency.USD).toString());
    }

    @Test
    public void test11() throws IOException {
        System.out.println(controller.currencyConvert(10D, EnumCurrency.JPY, EnumCurrency.CAD).toString());
    }

    @Test
    public void test12() throws IOException {
        System.out.println(controller.currencyConvert(10D, EnumCurrency.BTC, EnumCurrency.CAD).toString());
    }

    @Test
    public void test13() throws Exception {
        System.out.println(controller.currencyConvert(new CurrencyRequest()
                .setAmount(10D).setSource("Usd").setTarget("eur")).toString());
    }

    @Test
    public void test14() throws Exception {
        System.out.println(controller.currencyConvert(new CurrencyRequest()
                .setAmount(10D).setSource("jPy").setTarget("Cad")).toString());
    }

    @Test
    public void test15() throws Exception {
        System.out.println(controller.currencyConvert(new CurrencyRequest()
                .setAmount(10D).setSource("Usd").setTarget("EUR")).toString());
    }

    @Test
    public void test16() throws Exception {
        System.out.println(controller.currencyConvert(new CurrencyRequest()
                .setAmount(10D).setSource("BTC").setTarget("usd")).toString());
    }

    @Test
    public void test17() throws Exception {
        System.out.println(controller.currencyConvert(new CurrencyRequest()
                .setAmount(10D).setSource("Usd").setTarget("eur")).toString());
    }

    @Test
    public void test18() throws IOException {
        System.out.println(controller.currencyConvert(1D, EnumCurrency.USD, EnumCurrency.USD).toString());
    }

    @Test
    public void test19() throws IOException {
        System.out.println(controller.currencyConvert(1110D, EnumCurrency.USD, EnumCurrency.EUR).toString());
    }

    @Test
    public void test20() throws IOException {
        System.out.println(controller.currencyConvert(102D, EnumCurrency.JPY, EnumCurrency.USD).toString());
    }


    @Test
    public void test21() throws IOException {
        System.out.println(controller.currencyConvert(0D, EnumCurrency.JPY, EnumCurrency.CAD).toString());
    }


    @Test
    public void test22() throws IOException {
        System.out.println(controller.currencyConvert(-10D, EnumCurrency.BTC, EnumCurrency.CAD).toString());
    }


    @Test
    public void test23() throws Exception {
        System.out.println(controller.currencyConvert(new CurrencyRequest()
                .setAmount(1220D).setSource("Usd").setTarget("eur")).toString());
    }


    @Test
    public void test24() throws Exception {
        System.out.println(controller.currencyConvert(new CurrencyRequest()
                .setAmount(123123110D).setSource("jPy").setTarget("Cad")).toString());
    }


    @Test
    public void test25() throws Exception {
        System.out.println(controller.currencyConvert(new CurrencyRequest()
                .setAmount(177770D).setSource("Usd").setTarget("EUR")).toString());
    }


    @Test
    public void test26() throws Exception {
        System.out.println(controller.currencyConvert(new CurrencyRequest()
                .setAmount(-10D).setSource("BTC").setTarget("usd")).toString());
    }


    @Test
    public void test27() throws Exception {
        System.out.println(controller.currencyConvert(new CurrencyRequest()
                .setAmount(0D).setSource("Usd").setTarget("eur")).toString());
    }

    @Test
    public void test28() {
        System.out.println(controller.getCurrencies());
    }


    @Test
    public void test29() {
        Currency currency1 = new Currency();
        currency1.setTimeZone(ZoneId.systemDefault());
        currency1.setResult("1234567890-=!@#$%^&*()_+{}[]:;'?.,,.//asqwerty");
        currency1.setLocalDateTime(LocalDateTime.now());
        currency1.setCurrency(EnumCurrency.JPY);
        System.out.println(dao.save(currency1));
        Currency currency = new Currency();
        currency.setId(1L);
        currency.setLocalDateTime(LocalDateTime.now());
        currency.setResult("asdfghjkl;qwertyuiop[]zxcvbnm,./&*(&*(^(#^@%^#@!)_+_?");
        currency.setTimeZone(ZoneId.systemDefault());
        currency.setCurrency(EnumCurrency.CAD);
        controller.updateCurrencies(currency);
    }

    @Test
    public void test30() {
        Currency currency1 = new Currency();
        currency1.setTimeZone(ZoneId.systemDefault());
        currency1.setResult("1234567890-=!@#$%^&*()_+{}[]:;'?.,,.//asqwerty");
        currency1.setLocalDateTime(LocalDateTime.now());
        currency1.setCurrency(EnumCurrency.JPY);
        System.out.println(dao.save(currency1));
        controller.deleteCurrencies(1L);
    }

    @Test
    public void test31() {
        System.out.println(controller.getLocalDateTime().getTimeZone());
    }


}
