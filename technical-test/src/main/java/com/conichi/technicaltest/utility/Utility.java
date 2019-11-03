package com.conichi.technicaltest.utility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Map;

@Component
public class Utility {

    public Map<String, Object> jsonReader(String json) throws IOException {
        return new ObjectMapper().readValue(json, new TypeReference<Map<String, Object>>() {
        });
    }

    public UriComponentsBuilder addBuilderParam(UriComponentsBuilder builder, String source, String target, Double amount) {
        builder.queryParam("from", source)
                .queryParam("to", target)
                .queryParam("amount", amount);
        return builder;
    }

}
