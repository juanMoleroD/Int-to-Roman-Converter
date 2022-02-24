import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Int2RomanConverterTest {

    @Test
    void hasConverterMethod() {
        Int2RomanConverter converter = new Int2RomanConverter();
        assertEquals("I", converter.convert(1));
        assertEquals("II", converter.convert(2));
    }


}