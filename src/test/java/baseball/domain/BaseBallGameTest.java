package baseball.domain;

import baseball.domain.number.BaseballGameNumber;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

public class BaseBallGameTest {
    @Test
    public void calculateStrikeTest(){
        BaseballGameNumber com = new BaseballGameNumber(Arrays.asList(1,2,3));
        BaseballGameNumber player1 = new BaseballGameNumber(Arrays.asList(1,2,3));
        BaseballGameNumber player2 = new BaseballGameNumber(Arrays.asList(1,2,4));
        BaseballGameNumber player3 = new BaseballGameNumber(Arrays.asList(3,2,1));
        BaseballGameNumber player4 = new BaseballGameNumber(Arrays.asList(8,3,6));
        BaseBallGame game = new BaseBallGame();

        assertThat(game.calculateStrikes(com,player1)).isEqualTo(3);
        assertThat(game.calculateStrikes(com,player2)).isEqualTo(2);
        assertThat(game.calculateStrikes(com,player3)).isEqualTo(1);
        assertThat(game.calculateStrikes(com,player4)).isEqualTo(0);
    }
    @Test
    public void calculateContainedTest(){
        BaseballGameNumber com = new BaseballGameNumber(Arrays.asList(1,2,3));
        BaseballGameNumber player1 = new BaseballGameNumber(Arrays.asList(1,2,3));
        BaseballGameNumber player2 = new BaseballGameNumber(Arrays.asList(1,2,4));
        BaseballGameNumber player3 = new BaseballGameNumber(Arrays.asList(3,2,1));
        BaseballGameNumber player4 = new BaseballGameNumber(Arrays.asList(8,3,6));
        BaseBallGame game = new BaseBallGame();

        assertThat(game.countContained(com,player1)).isEqualTo(3);
        assertThat(game.countContained(com,player2)).isEqualTo(2);
        assertThat(game.countContained(com,player3)).isEqualTo(3);
        assertThat(game.countContained(com,player4)).isEqualTo(1);
    }
    @Test
    public void calculateBallTest(){
        BaseballGameNumber com = new BaseballGameNumber(Arrays.asList(1,2,3));
        BaseballGameNumber player1 = new BaseballGameNumber(Arrays.asList(1,2,3));
        BaseballGameNumber player2 = new BaseballGameNumber(Arrays.asList(1,2,4));
        BaseballGameNumber player3 = new BaseballGameNumber(Arrays.asList(3,2,1));
        BaseballGameNumber player4 = new BaseballGameNumber(Arrays.asList(8,3,6));
        BaseBallGame game = new BaseBallGame();

        assertThat(game.calculateBall(com,player1)).isEqualTo(0);
        assertThat(game.calculateBall(com,player2)).isEqualTo(0);
        assertThat(game.calculateBall(com,player3)).isEqualTo(2);
        assertThat(game.calculateBall(com,player4)).isEqualTo(1);
    }
    @Test
    void calculateAllTest(){
        BaseballGameNumber com = new BaseballGameNumber(Arrays.asList(1,2,3));
        BaseballGameNumber player1 = new BaseballGameNumber(Arrays.asList(1,2,3));
        BaseballGameNumber player2 = new BaseballGameNumber(Arrays.asList(1,2,4));
        BaseballGameNumber player3 = new BaseballGameNumber(Arrays.asList(3,1,2));
        BaseballGameNumber player4 = new BaseballGameNumber(Arrays.asList(8,4,6));
        BaseBallGame game1 = new BaseBallGame();
        BaseBallGame game2 = new BaseBallGame();
        BaseBallGame game3 = new BaseBallGame();
        BaseBallGame game4 = new BaseBallGame();

        game1.calculateAll(com,player1);
        game2.calculateAll(com,player2);
        game3.calculateAll(com,player3);
        game4.calculateAll(com,player4);
        assertThat(game1.getStrike()).isEqualTo(3);
        assertThat(game1.getBall()).isEqualTo(0);
        assertThat(game1.getNothing()).isEqualTo(false);
        assertThat(game2.getStrike()).isEqualTo(2);
        assertThat(game2.getBall()).isEqualTo(0);
        assertThat(game2.getNothing()).isEqualTo(false);
        assertThat(game3.getStrike()).isEqualTo(0);
        assertThat(game3.getBall()).isEqualTo(3);
        assertThat(game3.getNothing()).isEqualTo(false);
        assertThat(game4.getStrike()).isEqualTo(0);
        assertThat(game4.getBall()).isEqualTo(0);
        assertThat(game4.getNothing()).isEqualTo(true);
    }
}
