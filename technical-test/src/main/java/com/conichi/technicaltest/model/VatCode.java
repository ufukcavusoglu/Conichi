package com.conichi.technicaltest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VatCode {

    @JsonProperty("VatCode")
    private
    String vatCode;

    public String getVatCode() {
        return vatCode;
    }

    public VatCode setVatCode(String vatCode) {
        this.vatCode = vatCode;
        return this;
    }
}
