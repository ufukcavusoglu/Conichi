package com.conichi.technicaltest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryCode {

    @JsonProperty("CountryCode")
    private String countryCode;
    @JsonProperty("IsValid")
    private
    Boolean isValid;

    public Boolean getIsValid() {
        return isValid;
    }

    public CountryCode setIsValid(Boolean isValid) {
        this.isValid = isValid;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public CountryCode setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }
}
