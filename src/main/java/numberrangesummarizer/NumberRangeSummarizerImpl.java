package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class NumberRangeSummarizerImpl implements NumberRangeSummarizer{
    
    public Collection<Integer> collect(String input){

        input = input.replaceAll("\\s+",""); // replace all whitespaces
		if(input.isEmpty()){
            System.out.println("Please enter comma delimited list of numbers");
			return null;
		}else if (!input.matches("^[0-9,]*$")){ //checks for digits and commas only

            System.out.println("Your input seems to contain illegal characters, please enter comma delimited list of numbers");
            return null;
             
		}else {
			return InputToArraylist(input);
		}
    }

    public  String summarizeCollection(Collection<Integer> input){
        if (input == null) {
            return "Error";
        }
        else if(input.size() == 0){
            return "Error, Please enter comma delimited list of numbers";

        }else{

            ArrayList<Integer> inputLis = new ArrayList<Integer>(input);
            String str = ""; //initialize string

            for(int i = 0; i < inputLis.size(); i++) { 

                while (i < inputLis.size() - 1 && inputLis.get(i+1) == inputLis.get(i) + 1) {

                    if (!str.endsWith("-")) { //if str doesn't end with '-' add it
                        str = str + inputLis.get(i) + "-"; 
                    }i++;
                }
                str = str + inputLis.get(i) + ", ";
            }
            return str.substring(0,str.length()-2); // return string without the trailing comma
        }
    }

    private ArrayList<Integer> InputToArraylist(String input){

        String[] StringArray = input.split(",");
        ArrayList<Integer> IntList = new ArrayList<Integer>();

        for(String str: StringArray) { 
            try {
                int num = Integer.parseInt(str);
                IntList.add(num);
            } catch(Exception e) {
                // Skip non integer character
                continue;
            }
        }
        //Sort list
        Collections.sort(IntList);
        return IntList;
    }
}