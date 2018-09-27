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

}
