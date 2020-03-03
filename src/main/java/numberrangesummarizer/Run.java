package numberrangesummarizer;

import java.util.Scanner;

public class Run{

    public static void main(String[] args) {

        NumberRangeSummarizerImpl numSummerizer = new NumberRangeSummarizerImpl(); 

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter comma delimited list of numbers");
        
        String output = numSummerizer.summarizeCollection(numSummerizer.collect(input.next()));

        System.out.print("Result: ");
        System.out.println(output);

        input.close();
    }


}