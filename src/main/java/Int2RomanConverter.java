import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Int2RomanConverter {

    private final List<Integer> listOfNumeralValues = List.of(1,5,10,50,100,500,1000);

    private final HashMap<Integer, String> mapOfNumerals =
            new HashMap<Integer, String>(Map.of(
                    1, "I",
                    5,"V",
                    10, "X",
                    50, "L",
                    100, "C",
                    500, "D",
                    1000, "M"
    ));

    public String convert(int numberToConvert) {

        StringBuilder result = new StringBuilder();

        int numberToTransform = numberToConvert;

        for (int i = listOfNumeralValues.size() - 1; i >= 0; i--) {
            int currentNumeral = listOfNumeralValues.get(i);

            if (numberToTransform_isARomanNumerals(numberToTransform, currentNumeral)) {
                result.append(mapOfNumerals.get(currentNumeral));
                numberToTransform -= currentNumeral;

                if (numberToTransform > 0) { continue; }  else break;
            }

            if (numberToTransformMinusOne_isARomanNumerals(numberToTransform, currentNumeral)) {
                result.append("I").append(mapOfNumerals.get(currentNumeral));
                numberToTransform -= currentNumeral;
                continue;
            }

            if (numberToTransform/ currentNumeral >= 1) {
                int numberOfRepetitionsOfNumeral = numberToTransform/ currentNumeral;
                for (int repetitions = 0 ; repetitions < numberOfRepetitionsOfNumeral ; repetitions++ ) {
                    result.append(mapOfNumerals.get(currentNumeral));
                }
                numberToTransform-= currentNumeral;
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
