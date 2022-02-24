import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Int2RomanConverter {

    public String convert(int i) {

        HashMap<Integer, String> numeralReferences = new HashMap<Integer, String>(Map.of(
                1, "I",
                5,"V",
                10, "X",
                50, "L",
                100, "C",
                500, "D",
                1000, "M"
        ));

        if (numeralReferences.containsKey(i)) return numeralReferences.get(i);

        StringBuilder romanNumber = new StringBuilder();
        if (numeralReferences.containsKey(i+1)) romanNumber.append("I" + numeralReferences.get(i+1));

        if (numeralReferences.containsKey(i-1)) romanNumber.append(numeralReferences.get(i-1) + "I");





        return romanNumber.toString();
    }

}
