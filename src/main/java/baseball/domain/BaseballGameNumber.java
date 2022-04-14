package baseball.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @params
 * numbers : 숫자 / 위치
 */
public class BaseballGameNumber {
    private Map<Integer, Integer> numbers = new HashMap<>();

    public void setNumbers(Map<Integer, Integer> numbers) {
        this.numbers = numbers;
    }

    public Map<Integer, Integer> getNumbers() {
        return numbers;
    }
    public Boolean addNumber(Integer number, Integer index){
        if(numbers.containsKey(number)){
            return false;
        }
        if(numbers.containsValue(index)){
            return false;
        }
        numbers.put(number,index);
        return true;
    }

}
