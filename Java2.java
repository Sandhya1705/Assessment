import java.util.HashMap;
import java.util.Scanner;

public class Java2{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Roman numeral: ");
        String romanNumeral = scanner.nextLine();
        scanner.close();

        int result = romanToInteger(romanNumeral);
        if (result == -1) {
            System.out.println("Invalid Roman numeral.");
        } else {
            System.out.println("Integer value: " + result);
        }
    }

    public static int romanToInteger(String s) {
        HashMap<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int currentValue = romanValues.get(currentChar);

            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            prevValue = currentValue;
        }

        
        if (integerToRoman(result).equals(s)) {
            return result;
        } else {
            return -1;
        }
    }

    public static String integerToRoman(int num) {
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder roman = new StringBuilder();
        int i = 0;

        while (num > 0) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(symbols[i]);
            }
            i++;
        }

        return roman.toString();
    }
}
