package tdd;

import org.junit.Test;

import static org.junit.Assert.*;
import static tdd.NumberInfo.*;

public class NumberInfoTest {

    @Test
    public void testInfoReturnsTheNumberWhenNotDivisibleByAnyWhenValueIsTwo() {
        String expected = "2";
        String actual = info(2);
        assertEquals(expected, actual);
    }

    @Test
    public void testInfoReturnsTheNumberWhenNotDivisibleByAnyWhenValueIsEleven() {
        String expected = "11";
        String actual = info(11);
        assertEquals(expected, actual);
    }

    @Test
    public void testInfoReturnsDivisibleByThreeWhenThree() {
        String expected = "Divisible by 3";
        String actual = info(3);
        assertEquals(expected, actual);
    }

    @Test
    public void testInfoReturnsDivisibleByThreeWhenNine() {
        String expected = "Divisible by 3";
        String actual = info(9);
        assertEquals(expected, actual);
    }

    @Test
    public void testInfoReturnsDivisibleByFiveWhenFive() {
        String expected = "Divisible by 5";
        String actual = info(5);
        assertEquals(expected, actual);
    }

    @Test
    public void testInfoReturnsDivisibleByFiveWhenTen() {
        String expected = "Divisible by 5";
        String actual = info(10);
        assertEquals(expected, actual);
    }

    @Test
    public void testInfoReturnsDivisibleByThreeAndFiveWhenFifteen() {
        String expected = "Divisible by 3 and 5";
        String actual = info(15);
        assertEquals(expected, actual);
    }

    @Test
    public void testInfoReturnsDivisibleByThreeAndFiveWhenThirty() {
        String expected = "Divisible by 3 and 5";
        String actual = info(30);
        assertEquals(expected, actual);
    }
}