
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Java3{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();
        scanner.close();

        boolean isPangram = checkIfPangram(input);
        
        if (isPangram) {
            System.out.println("The input is a pangram.");
        } else {
            System.out.println("The input is not a pangram.");
        }
    }

    public static boolean checkIfPangram(String input) {
        
        Set<Character> alphabetSet = new HashSet<>();

        for (char c : input.toCharArray()) {
     
            if (Character.isLetter(c)) {
               
                char lowercaseChar = Character.toLowerCase(c);
                alphabetSet.add(lowercaseChar);
            }
        }

        return alphabetSet.size() == 26;
    }
}


