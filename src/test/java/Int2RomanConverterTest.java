import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Int2RomanConverterTest {

    Int2RomanConverter converter = new Int2RomanConverter();

    @Test
    void converts_numbersOnNumerals() {
        assertEquals("I", converter.convert(1));
        assertEquals("V", converter.convert(5));
        assertEquals("X", converter.convert(10));
        assertEquals("L", converter.convert(50));
        assertEquals("C", converter.convert(100));
        assertEquals("D", converter.convert(500));
        assertEquals("M", converter.convert(1000));

    }

    @Test
    void converts_numeralsMinus1() {
        assertEquals("IV", converter.convert(4));
        assertEquals("IX", converter.convert(9));
        assertEquals("XLIX", converter.convert(49));
        assertEquals("XCIX", converter.convert(99));
        assertEquals("CDXCIX", converter.convert(499));

    }

    @Test
    void converts_numeralsPlus1() {
        assertEquals("VI", converter.convert(6));
        assertEquals("XI", converter.convert(11));
        assertEquals("CI", converter.convert(101));
    }

    @Test
    void converts_numeralsPlus2() {
        assertEquals("XII", converter.convert(12));
        assertEquals("LII", converter.convert(52));
        assertEquals("CII", converter.convert(102));
        assertEquals("DII", converter.convert(502));
    }

    @Test
    void converts_numeralsPlus5() {
        assertEquals("XV", converter.convert(15));
        assertEquals("LV", converter.convert(55));
        assertEquals("CV", converter.convert(105));
        assertEquals("DV", converter.convert(505));
    }

    @Test
    void converts_complexNumerals() {
        assertEquals("DCCXXVII", converter.convert(727));
        assertEquals("LXXXVIII", converter.convert(88));
        assertEquals("CXXXIV", converter.convert(134));
        assertEquals("CCCXXXIII", converter.convert(333));
        assertEquals("CCLVI", converter.convert(256));
    }

    @Test
    void converts_higherLevelFoursAndNines() {
        assertEquals("CMXCI",converter.convert(991));
    }



}