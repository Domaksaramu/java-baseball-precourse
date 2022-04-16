package baseball.domain;

public class Game {
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

    public void calculateStrikes(BaseballGameNumber thisNumbers, BaseballGameNumber thatNumbers){
    }

    public Boolean compare(BaseballGameNumber thisNumbers, BaseballGameNumber thatNumbers){
        /*for (Integer number: thatNumbers.getNumbers().keySet()) {
            if(thisNumbers.getNumbers().containsKey(number)){
                if(thisNumbers.getNumbers().get(number) == thatNumbers.getNumbers().get(number)){
                    strike+=1;
                }
                else{
                    ball+=1;
                }
            }
            else{
                continue;
            }
        }
        if(strike==0 && ball==0)
            nothing = true;*/
        return false;
    }
}
