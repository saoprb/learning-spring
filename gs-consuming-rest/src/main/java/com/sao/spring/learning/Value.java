package com.sao.spring.learning;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Sao Paulo Boco on 2/26/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {

    private Long id;
    private String quote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return new StringBuffer()
                .append("Value{id=")
                .append(id)
                .append(", quote='")
                .append(quote)
                .append("'}")
                .toString();
    }
}
