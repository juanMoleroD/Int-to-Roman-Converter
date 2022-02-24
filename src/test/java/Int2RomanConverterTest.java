import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Int2RomanConverterTest {

    Int2RomanConverter converter = new Int2RomanConverter();

    @Test
    void converts_numbersOnNumerals() {
        assertEquals("I", converter.convert(1));
        assertEquals("V", converter.convert(5));
    }

    @Test
    void converts_numeralsMinus1() {
        assertEquals("IV", converter.convert(4));
        assertEquals("IX", converter.convert(9));
        assertEquals("IL", converter.convert(49));
        assertEquals("IC", converter.convert(99));
        assertEquals("ID", converter.convert(499));
    }

    @Test
    void converts_numeralsPlus1() {
        assertEquals("VI", converter.convert(6));
        assertEquals("XI", converter.convert(11));

    }
}