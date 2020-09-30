import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        SolutionBcknd solutionBcknd = new SolutionBcknd();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Please Enter the numerator of fraction 1. Enter negative sign if needed.");
            int frac_num1 = Integer.parseInt(br.readLine());
            System.out.println("Please Enter the denominator of fraction 1. Enter negative sign if needed.");
            int frac_den1 = Integer.parseInt(br.readLine());
            System.out.println("Please Enter the operation of * or /. (defaults to multiplication)");
            String Operation = (br.readLine());
            System.out.println("Please Enter the numerator of fraction 2. Enter negative sign if needed.");
            int frac_num2 = Integer.parseInt(br.readLine());
            System.out.println("Please Enter the denominator of fraction 2. Enter negative sign if needed.");
            int frac_den2 = Integer.parseInt(br.readLine());
            Answer answer = solutionBcknd.mult_main(frac_num1, frac_den1, frac_num2, frac_den2, Operation);
            if (!answer.answer_valid) {
                System.out.println("Sorry, there was an error in your inputs. Do not use 0 in the denom.");
            } else if (answer.answer_num == 0) {
                System.out.println("0 is the answer.");
            } else if (answer.answer_denom == 1) {
                System.out.println(answer.answer_num / answer.answer_denom + " is the answer.");
            } else if (answer.answer_denom < Math.abs(answer.answer_num)) {
                System.out.println((answer.answer_num) + "/" + (answer.answer_denom) + " is the answer or " + solutionBcknd.print_mixed(answer));
            } else {
                System.out.println((answer.answer_num) + "/" + (answer.answer_denom) + " is the answer.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Only enter integers. Quitting...");
        }
    }
}