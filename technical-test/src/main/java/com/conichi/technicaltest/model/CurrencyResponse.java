package com.conichi.technicaltest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.ZoneId;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyResponse {

    @JsonProperty("Result")
    public String result;
    @JsonProperty("TimeZone")
    public ZoneId timeZone;
    @JsonProperty("LocalDateTime")
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    public LocalDateTime localDateTime;
    public String error;
    public EnumCurrency enumCurrency;

    public EnumCurrency getEnumCurrency() {
        return enumCurrency;
    }

    public CurrencyResponse setEnumCurrency(EnumCurrency enumCurrency) {
        this.enumCurrency = enumCurrency;
        return this;
    }

    public String getError() {
        return error;
    }

    public CurrencyResponse setError(String error) {
        this.error = error;
        return this;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public ZoneId getTimeZone() {
        return timeZone;
    }

    public CurrencyResponse setTimeZone(ZoneId timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    public CurrencyResponse setLocalDateTime(LocalDateTime currentLocalDateTime) {
        this.localDateTime = currentLocalDateTime;
        return this;
    }


    public String getResult() {
        return result;
    }

    public CurrencyResponse setResult(String result) {
        this.result = result;
        return this;
    }
}
