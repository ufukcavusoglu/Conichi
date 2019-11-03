package com.conichi.technicaltest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class CurrencyRequest {

    @JsonProperty("Amount")
    private Double amount;
    @JsonProperty("SourceCurrency")
    private String source;
    @JsonProperty("TargetCurrency")
    private String target;

    public Double getAmount() {
        return amount;
    }

    public CurrencyRequest setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public String getSource() throws Exception {
        return currencyWithoutCaseSensitivity(source);
    }

    public CurrencyRequest setSource(String source) {
        this.source = source;
        return this;
    }

    public String getTarget() throws Exception {
        return currencyWithoutCaseSensitivity(target);
    }

    public CurrencyRequest setTarget(String target) {
        this.target = target;
        return this;
    }

    private static String currencyWithoutCaseSensitivity(String currency) throws Exception {
        return Arrays.stream(((Class<? extends Enum<?>>) EnumCurrency.class).getEnumConstants())
                .map(Enum::name)
                .filter(currency::equalsIgnoreCase)
                .findFirst().orElseThrow(Exception::new);
    }

}
