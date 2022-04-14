package baseball.DTO;

import java.util.Map;
import java.util.Set;

/**
 * @params
 * numbers : 숫자 / 위치
 * strikes : 스트라이크 횟수
 * balls : 볼 횟수
 * nothing : 낫싱 횟수
 */
public class BaseballGameSetDTO {
    private Set<Integer> numbers;
    private Integer strikes;
    private Integer balls;
    private Integer nothing;

    public Set<Integer> getNumbers(){
        return numbers;
    }

    public Integer getStrikes(){
        return strikes;
    }

    public Integer getBalls(){
        return balls;
    }

    public Integer getNothing(){
        return nothing;
    }

    public void setNumbers(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public void setBalls(Integer balls) {
        this.balls = balls;
    }

    public void setNothing(Integer nothing) {
        this.nothing = nothing;
    }

    public void setStrikes(Integer strikes) {
        this.strikes = strikes;
    }

    public String toString(){
        String result = "";
        if(balls != 0){
            result += balls + "볼";
        }
        if (strikes != 0){
            result += " " + strikes +"스트라이크";
        }
        if(balls==0 && strikes==0){
            result = "낫싱";
        }
        return result.trim();
    }
}
