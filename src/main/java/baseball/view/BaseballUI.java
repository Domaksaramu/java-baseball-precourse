package baseball.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseballUI {
    private Scanner scanner = new Scanner(System.in);
    String pattern = "[0-9]*";


    public BaseballUI(){

    }
    public String getUserInput(Scanner scanner){
        this.scanner = scanner;
        String pattern = "[0-9]*";
        return this.scanner.next(pattern);
    }
    public Boolean isFlag(String input){
        if(input.length()==1)
            return true;
        return false;
    }
    public Boolean isNumber(String input){
        if(input.length()==3)
            return true;
        return false;
    }
    public Boolean checkInputEnable(String input){
        if(isNumber(input) || isFlag(input))
            return true;
        return false;
    }
    public List<Integer> parseUserInput(String input){
        List<Integer> numberList = new ArrayList<>();
        String[] inputArray = input.split("");
        for (String s: inputArray ) {
            numberList.add(Integer.valueOf(s));
        }
        return numberList;
    }

}
