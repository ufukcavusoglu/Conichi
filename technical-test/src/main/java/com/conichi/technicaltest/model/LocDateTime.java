package com.conichi.technicaltest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZoneId;

public class LocDateTime {

    @JsonProperty("TimeZone")
    public ZoneId timeZone;
    @JsonProperty("LocalDateTime")
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    public java.time.LocalDateTime localDateTime;

    public ZoneId getTimeZone() {
        return timeZone;
    }

    public LocDateTime setTimeZone(ZoneId timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    public java.time.LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public LocDateTime setLocalDateTime(java.time.LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
        return this;
    }
}
