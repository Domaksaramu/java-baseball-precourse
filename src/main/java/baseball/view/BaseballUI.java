package baseball.view;

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
    public List<Integer> parseUserInput(String input){
        return null;
    }

}
