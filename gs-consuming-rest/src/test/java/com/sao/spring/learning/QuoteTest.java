package com.sao.spring.learning;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Sao Paulo Boco on 2/26/2017.
 */
public class QuoteTest {
    @Test
    public void givenHelloWhenGetSetTypeThenHello() {
        Quote quote = new Quote();
        quote.setType("Hello");
        Assert.assertEquals("Hello", quote.getType());
    }

    @Test
    public void givenValueIdTenWhenGetSetValueThenValueIdTen() {
        Quote quote = new Quote();
        Value value = new Value();
        value.setId(new Long(10));
        quote.setValue(value);
        Assert.assertEquals(new Long(10), quote.getValue().getId());
    }

    @Test
    public void toStringTest() {
        Value value = new Value();
        value.setId(new Long(10));
        value.setQuote("Hello");

        Quote quote = new Quote();
        quote.setType("World");
        quote.setValue(value);

        Assert.assertEquals("Quote{type='World', value=Value{id=10, quote='Hello'}}", quote.toString());
    }
}
