package com.sao.spring.learning;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Sao Paulo Boco on 2/26/2017.
 */
public class ValueTest {
    @Test
    public void givenTenWhenSetGetIdThenTen() {
        Value value = new Value();
        value.setId(new Long(10));
        Assert.assertEquals(new Long(10), value.getId());
    }

    @Test
    public void givenQuoteHelloWhenGetSetQuoteThenQuoteHello() {
        Value value = new Value();
        value.setQuote("Hello");
        Assert.assertEquals("Hello", value.getQuote());
    }

    @Test
    public void toStringTest() {
        Value value = new Value();
        value.setId(new Long(10));
        value.setQuote("Hello");
        Assert.assertEquals("Value{id=10, quote='Hello'}", value.toString());
    }
}
