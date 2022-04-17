package baseball.domain.number;

import java.util.*;

/**
 * @params
 */
public class BaseballGameNumber{
    protected List<Integer> numberList = new ArrayList<>();
    public static final Integer MAX_BASEBALL_NUMBER = 3;

    public BaseballGameNumber(List<Integer> numberList){
        if(!checkNumberListSize(numberList))
            throw new IllegalArgumentException("입력된 문자열이 너무 깁니다.");
        this.numberList = numberList;
    }

    public BaseballGameNumber(){}

    public void setNumberList(List<Integer> numberList) {
        this.numberList = new ArrayList<>();
        if(!checkNumberListSize(numberList))
            throw new IllegalArgumentException("입력된 문자열이 너무 깁니다.");
        Boolean insertFlag = true ;
        for (Integer item: numberList) {
            addNumber(item);
        }

    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public Boolean checkDuplicateNumber(Integer number){
        return numberList.contains(number);
    }
    public Integer countDuplicateNumber(Integer number){
        Integer count = 0;
        if(numberList.contains(number))
            count++;
        return count;
    }
    public Integer countExactlyEqualNumber(Integer value, Integer index){
        Integer count = 0;
        if(numberList.get(index) == value)
            count++;
        return count;
    }
    public Boolean checkNumberListSize(List<Integer> numberList){
        return numberList.size()<= MAX_BASEBALL_NUMBER;
    }

    public Boolean addNumber(Integer number){
        if(checkDuplicateNumber(number))
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        if(numberList.size()>= MAX_BASEBALL_NUMBER)
            throw new IllegalArgumentException("입력된 문자열이 너무 깁니다.");
        numberList.add(number);
        return true;
    }
    public Integer getNumberListSize(){
        return this.numberList.size();
    }
}
