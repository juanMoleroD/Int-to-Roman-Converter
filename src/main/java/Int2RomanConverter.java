import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class Int2RomanConverter {

    private final List<Integer> listOfNumeralValues = List.of(1,4,5,9,10,40,50,90,100,400,500,900,1000);

    private final HashMap<Integer, String> mapOfNumerals =
            new HashMap<Integer, String>(Map.ofEntries(
                    entry(1, "I"),
                    entry(4,"IV"),
                    entry(5,"V"),
                    entry(9,"IX"),
                    entry(10, "X"),
                    entry(40, "XL"),
                    entry(50, "L"),
                    entry(90, "XC"),
                    entry(100, "C"),
                    entry(400, "CD"),
                    entry(500, "D"),
                    entry(900, "CM"),
                    entry(1000, "M")
    ));

    public String convert(int numberToConvert) {

        StringBuilder result = new StringBuilder();

        int numberToTransform = numberToConvert;

        for (int positionOnList = listOfNumeralValues.size() - 1; positionOnList >= 0; positionOnList--) {
            int currentNumeralValue = listOfNumeralValues.get(positionOnList);
            String currentNumeralString = mapOfNumerals.get(currentNumeralValue);

            if (numberToTransform_isARomanNumerals(numberToTransform, currentNumeralValue)) {
                result.append(currentNumeralString);
                numberToTransform -= currentNumeralValue;

                if (numberToTransform > 0) { continue; }  else break;
            }

            if (numberToTransformMinusOne_isARomanNumerals(numberToTransform, currentNumeralValue)) {
                result.append("I").append(currentNumeralString);
                numberToTransform -= currentNumeralValue;
                continue;
            }

            if (numberToTransform/ currentNumeralValue >= 1) {
                int numberOfRepetitionsOfNumeral = numberToTransform/ currentNumeralValue;
                for (int repetitions = 0 ; repetitions < numberOfRepetitionsOfNumeral ; repetitions++ ) {
                    result.append(currentNumeralString);
                }
                numberToTransform-= currentNumeralValue;
            }
        }

        return result.toString();
    }

    private boolean numberToTransformMinusOne_isARomanNumerals(int number, int numberToCompareTo) {
        return (number + 1) == numberToCompareTo;
    }

    private boolean numberToTransform_isARomanNumerals(int number, int numberToCompareTo) {
        return number == numberToCompareTo;
    }

}
