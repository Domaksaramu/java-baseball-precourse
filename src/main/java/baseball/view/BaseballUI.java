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
        String buffer;
        try {
            buffer = this.scanner.next(pattern);
        }catch (Exception e){
            throw new IllegalArgumentException("잘못된 문자를 입력하셨습니다.");
        }
    }
    public Boolean isFlag(String input){
        if(input.length()!=1)
            throw new IllegalArgumentException("종료 문자가 너무 길거나 짧습니다.");
        if(!input.equals("1")&&!input.equals("2"))
            throw new IllegalArgumentException("잘못된 문자를 입력하셨습니다.");
        return input.equals("1");
    }
    public Boolean isNumber(String input){
        if(input.length()==3)
            return true;
        throw new IllegalArgumentException("입력된 숫자열이 너무 길거나 짧습니다.");
    }
    public Boolean checkInputEnable(String input){
        if(isNumber(input) || isFlag(input))
            return true;
        return false;
    }
    public List<Integer> parseUserInputIntoNumbers(String input) throws IllegalArgumentException{
        List<Integer> numberList = new ArrayList<>();
        String[] inputArray = input.split("");
        for (String s: inputArray ) {
            numberList.add(Integer.valueOf(s));
        }
        return numberList;
    }
    public Boolean parseUserInputIntoExitFlag(String input){

    }

}
