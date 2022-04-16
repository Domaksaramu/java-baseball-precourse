package baseball.domain.number;

import java.util.*;

/**
 * @params
 */
public class BaseballGameNumber{
    protected List<Integer> numberList = new ArrayList<>();
    public static final Integer MAX_BASEBALL_NUMBER = 3;

    public BaseballGameNumber(List<Integer> numberList){
        if(checkNumberListSize(numberList))
            return;
        this.numberList = numberList;
    }

    public BaseballGameNumber(){}

    public void setNumberList(List<Integer> numberList) {
        if(checkNumberListSize(numberList))
            return;
        this.numberList = numberList;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public Boolean checkDuplicateNumber(Integer number){
        return numberList.contains(number);
    }
    public Boolean checkNumberListSize(List<Integer> numberList){
        return numberList.size()>= MAX_BASEBALL_NUMBER;
    }

    public Boolean addNumber(Integer number){
        if(checkDuplicateNumber(number))
            return false;
        if(checkNumberListSize(numberList))
            return false;
        numberList.add(number);
        return true;
    }
}
