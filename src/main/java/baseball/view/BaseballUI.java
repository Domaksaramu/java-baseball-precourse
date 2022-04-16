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
        return buffer;
    }
    public Boolean isFlag(String input){
        return (input.equals("1") || input.equals("2"));
    }
    public Boolean checkLength(String input){
        Integer len = input.length();
        return (len==3) || (len==1);
    }
    public Boolean checkInputEnable(String input){
        Integer len = input.length();
        if(!checkLength(input))
            throw new IllegalArgumentException("입력된 숫자열이 너무 길거나 짧습니다.");
        if(input.length()==1 && !isFlag(input))
            throw new IllegalArgumentException("잘못된 종료문자를 입력하셨습니다.");
        return true;
    }
    public List<Integer> parseUserInputIntoNumbers(String input){
        List<Integer> numberList = new ArrayList<>();
        String[] inputArray = input.split("");
        for (String s: inputArray ) {
            numberList.add(Integer.valueOf(s));
        }
        return numberList;
    }
    public Boolean parseUserInputIntoExitFlag(String input){
        return input.equals("1");
    }

}
