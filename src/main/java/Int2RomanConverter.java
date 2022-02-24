import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Int2RomanConverter {

    private final List<Integer> numeralValuesList = List.of(1,5,10,50,100,500,1000);

    private final HashMap<Integer, String> numeralReferences =
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

        StringBuilder romanNumber = new StringBuilder();

        for (int i = numeralValuesList.size() - 1, operatorNumber = numberToConvert; i >= 0; i--) {
            if (isNumberInNumerals(operatorNumber, numeralValuesList.get(i))) {
                romanNumber.append(numeralReferences.get(numeralValuesList.get(i)));
                operatorNumber -= numeralValuesList.get(i);

                if (operatorNumber > 0) { continue; }  else break;
            }

            if (isNumberMinusOneInNumerals(operatorNumber, numeralValuesList.get(i))) {
                romanNumber.append("I").append(numeralReferences.get(numeralValuesList.get(i)));
                operatorNumber -= numeralValuesList.get(i);
                continue;
            }

            if (operatorNumber/numeralValuesList.get(i) >= 1) {
                int roundedInt = operatorNumber/numeralValuesList.get(i);
                for (int repetitions = 0 ; repetitions < roundedInt ; repetitions++ ) {
                    romanNumber.append(numeralReferences.get(numeralValuesList.get(i)));
                }
                operatorNumber-= numeralValuesList.get(i);
            }
        }

        return romanNumber.toString();
    }

    private boolean isNumberMinusOneInNumerals(int number, int numberToCompareTo) {
        return (number + 1) == numberToCompareTo;
    }

    private boolean isNumberInNumerals(int number, int numberToCompareTo) {
        return number == numberToCompareTo;
    }

}
