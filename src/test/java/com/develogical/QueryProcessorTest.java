package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutJedi() throws Exception {
        assertThat(queryProcessor.process("jedi"), containsString("they fight the sith"));
    }

    @Test
    public void respondsWithOurName() throws Exception {
        assertThat(queryProcessor.process("a8906340: what is your name"), containsString("naughtiest-maximus"));
    }

    @Test
    public void responseWithLargertNumber() throws Exception {
        assertThat(queryProcessor.process("a8906340: which of the following numbers is the largest: 105, 815, 15, 58"), containsString("815"));
    }

    @Test
    public void responseWithAddtion() throws Exception {
        assertThat(queryProcessor.process("a8906340: what is 17 plus 9"), containsString("26"));
    }

    @Test
    public void responseWithMultiplication() throws Exception {
        assertThat(queryProcessor.process("e14ec460: what is 2 multiplied by 16"), containsString("32"));
    }

    @Test
    public void responseWithBothSquareAndCube() throws Exception {
        assertThat(queryProcessor.process("e14ec460: which of the following numbers is both a square and a cube: 325, 2116, 887, 531441"), containsString("531441"));
    }

    @Test
    public void responseWithPrimeNumber() throws Exception {
        assertThat(queryProcessor.process("e14ec460: which of the following numbers are primes: 221, 131, 193, 173"), containsString("131, 193, 173"));
    }





}
