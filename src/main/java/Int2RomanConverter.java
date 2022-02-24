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
            int currentNumeralValue = listOfNumeralValues.get(i);
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
