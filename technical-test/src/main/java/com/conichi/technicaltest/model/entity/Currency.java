package com.conichi.technicaltest.model.entity;


import com.conichi.technicaltest.model.EnumCurrency;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Embeddable
@Table
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonProperty("Result")
    public String result;
    @JsonProperty("Currency")
    public EnumCurrency currency;
    @JsonProperty("TimeZone")
    public ZoneId timeZone;
    @JsonProperty("LocalDateTime")
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    public LocalDateTime localDateTime;

    public Currency() {
    }

    public EnumCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(EnumCurrency currency) {
        this.currency = currency;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ZoneId getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(ZoneId timeZone) {
        this.timeZone = timeZone;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
