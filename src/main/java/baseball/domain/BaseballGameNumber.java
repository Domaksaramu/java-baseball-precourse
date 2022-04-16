package baseball.domain;

import java.util.*;

/**
 * @params
 */
public class BaseballGameNumber{
    private List<Integer> numberList = new ArrayList<>();
    private final Integer MAX_BASEBALL_NUMBER = 3;

    public BaseballGameNumber(List<Integer> numberList){this.numberList = numberList;}
    public BaseballGameNumber(){}

    public void setNumbers(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public List<Integer> getNumbers() {
        return numberList;
    }

    public Boolean checkDuplicateNumber(Integer number){
        return numberList.contains(number);
    }
    public Boolean checkNumberListSize(){
        return numberList.size()>= MAX_BASEBALL_NUMBER;
    }

    public Boolean addNumber(Integer number){
        if(checkDuplicateNumber(number))
            return false;
        if(checkNumberListSize())
            return false;
        numberList.add(number);
        return true;
    }
}
