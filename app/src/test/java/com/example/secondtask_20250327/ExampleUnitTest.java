package com.example.secondtask_20250327;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void empty_String_When_CountWords_Then_Return_Zero() {
        String givenString = "";

        int expectedRes = 0;
        int actualRes = Calculator.countWords(givenString);
        assertEquals(expectedRes, actualRes);
    }

    @Test
    public void null_String_When_CountWords_Then_Return_Zero() {
        String givenString = null;

        int expectedRes = 0;
        int actualRes = Calculator.countWords(givenString);
        assertEquals(expectedRes, actualRes);
    }

    @Test
    public void input_OneWord_When_CountWords_Then_Return_One() {
        String givenString = "Hello";

        int expectedRes = 1;
        int actualRes = Calculator.countWords(givenString);
        assertEquals(expectedRes, actualRes);
    }

    @Test
    public void input_MultipleWords_When_CountWords_Then_Return_CorrectCount() {
        String givenString = "Laba diena su vistiena";

        int expectedRes = 4;
        int actualRes = Calculator.countWords(givenString);
        assertEquals(expectedRes, actualRes);
    }

    @Test
    public void input_SymbolsOnly_When_CountWords_Then_Return_Zero() {
        String givenString = "!@#$%^&*()_+";

        int expectedRes = 0;
        int actualRes = Calculator.countWords(givenString);
        assertEquals(expectedRes, actualRes);
    }

    @Test
    public void whitespace_Only_When_CountWords_Then_Return_Zero() {
        String givenString = "     ";

        int expectedRes = 0;
        int actualRes = Calculator.countWords(givenString);
        assertEquals(expectedRes, actualRes);
    }

    @Test
    public void empty_String_When_CountCharacters_Then_Return_Zero() {
        String givenString = "";

        int expectedRes = 0;
        int actualRes = Calculator.countCharacters(givenString);
        assertEquals(expectedRes, actualRes);
    }

    @Test
    public void null_String_When_CountCharacters_Then_Return_Zero() {
        String givenString = null;

        int expectedRes = 0;
        int actualRes = Calculator.countCharacters(givenString);
        assertEquals(expectedRes, actualRes);
    }

    @Test
    public void input_OneWord_When_CountCharacters_Then_Return_CorrectCount() {
        String givenString = "Nebeprisikiskiakopusteliaujantiesiems";

        int expectedRes = 37;
        int actualRes = Calculator.countCharacters(givenString);
        assertEquals(expectedRes, actualRes);
    }

    @Test
    public void input_MultipleWords_When_CountCharacters_Then_Return_CorrectCount() {
        String givenString = "Laba diena su vistiena";

        int expectedRes = 22;
        int actualRes = Calculator.countCharacters(givenString);
        assertEquals(expectedRes, actualRes);
    }

    @Test
    public void input_SymbolsOnly_When_CountCharacters_Then_Return_CorrectCount() {
        String givenString = "!@#*&^*&(*^^)#$%^&*()_+";

        int expectedRes = 24;
        int actualRes = Calculator.countCharacters(givenString);
        assertEquals(expectedRes, actualRes);
    }

    @Test
    public void whitespace_Only_When_CountWords_Then_Return_CorrectCount() {
        String givenString = "          ";

        int expectedRes = 10;
        int actualRes = Calculator.countCharacters(givenString);
        assertEquals(expectedRes, actualRes);
    }
}