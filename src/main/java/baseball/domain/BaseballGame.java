package baseball.domain;

import baseball.domain.number.BaseballGameNumber;

import java.util.List;

public class BaseballGame {
    private Integer strike = 0;
    private Integer ball = 0 ;
    private Boolean nothing = false;
    private Boolean exitFlag = false;

    public Integer getBall() {
        return ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public Boolean getNothing() {
        return nothing;
    }

    public Boolean getExitFlag(){ return exitFlag;}

    public void setStrike(Integer strike) {
        this.strike = strike;
    }

    public void setBall(Integer ball) {
        this.ball = ball;
    }

    public void setNothing(Boolean nothing) {
        this.nothing = nothing;
    }

    public void setExitFlag(Boolean exitFlag) { this.exitFlag = exitFlag; }

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
        Integer containedCnt = countContained(thisNumbers, thatNumbers);
        return containedCnt - strike;
    }

    public void calculateAll(BaseballGameNumber thisNumbers, BaseballGameNumber thatNumbers){
        initValues();
        this.strike = calculateStrikes(thisNumbers, thatNumbers);
        this.ball = calculateBall(thisNumbers, thatNumbers);
        if(this.strike == 0 && this.ball==0)
            this.nothing = true;
        this.exitFlag = this.strike == 3 && this.ball==0 && !this.nothing;
    }
    @Override
    public String toString(){
        String result = "";
        if(ball!=0)
            result+=ball+"볼 ";
        if(strike!=0)
            result+=" "+ strike+"스트라이크 ";
        if(this.nothing)
            result="낫싱";
        return result.trim();
    }
}
