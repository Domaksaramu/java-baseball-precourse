package baseball.domain;

import baseball.domain.number.BaseballGameNumber;

import java.util.List;

public class BaseBallGame {
    private Integer strike = 0;
    private Integer ball = 0 ;
    private Boolean nothing = false;

    public Integer getBall() {
        return ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public Boolean getNothing() {
        return nothing;
    }

    public void setStrike(Integer strike) {
        this.strike = strike;
    }

    public void setBall(Integer ball) {
        this.ball = ball;
    }

    public void setNothing(Boolean nothing) {
        this.nothing = nothing;
    }
    public void initValues(){
        strike = 0;
        ball = 0;
        nothing = false;
    }

    public Integer calculateStrikes(BaseballGameNumber thisNumbers, BaseballGameNumber thatNumbers){
        List<Integer> thatNumbersList = thatNumbers.getNumberList();
        Integer count = 0;
        for (int i = 0; i < thisNumbers.getNumberListSize(); i++) {
            count+=thisNumbers.countExactlyEqualNumber(thatNumbersList.get(i), i);
        }
        return count;
    }
    public Integer countContained(BaseballGameNumber thisNumbers, BaseballGameNumber thatNumbers){
        List<Integer> thatNumbersList = thatNumbers.getNumberList();
        Integer count = 0;
        for (int i = 0; i < thisNumbers.getNumberListSize(); i++) {
            count+=thisNumbers.countDuplicateNumber(thatNumbersList.get(i));
        }
        return count;
    }
    public Integer calculateBall(BaseballGameNumber thisNumbers, BaseballGameNumber thatNumbers){
        Integer strike = calculateStrikes(thisNumbers, thatNumbers);
        Integer containdCnt = countContained(thisNumbers, thatNumbers);
        return containdCnt - strike;
    }

    public void calculateAll(BaseballGameNumber thisNumbers, BaseballGameNumber thatNumbers){
        initValues();
        this.strike = calculateStrikes(thisNumbers, thatNumbers);
        this.ball = calculateBall(thisNumbers, thatNumbers);
        if(this.strike == 0 && this.ball==0)
            this.nothing = true;
    }
}
