package baseball.domain.number;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class BassballGameNumberTest {
    @Test
    void duplicatedNumberTest(){
        List<Integer> basePlayerInput = new ArrayList<>(Arrays.asList(1,2));
        BaseballGameNumber player = new BaseballGameNumber(basePlayerInput);
        assertThat(player.checkDuplicateNumber(1)).isEqualTo(true);
        assertThat(player.checkDuplicateNumber(2)).isEqualTo(true);
        assertThat(player.checkDuplicateNumber(3)).isEqualTo(false);
    }
    @Test
    void duplicatedNumberInputTest(){
        List<Integer> basePlayerInput = new ArrayList<>(Arrays.asList(1,2));
        BaseballGameNumber player = new BaseballGameNumber(basePlayerInput);
        assertThat(player.addNumber(1)).isEqualTo(false);
        assertThat(player.addNumber(2)).isEqualTo(false);
        assertThat(player.addNumber(3)).isEqualTo(true);
        assertThat(player.addNumber(3)).isEqualTo(false);
    }
    @Test
    void oversizeInputTest(){
        BaseballGameNumber player = new BaseballGameNumber();
        assertThat(player.addNumber(1)).isEqualTo(true);
        assertThat(player.addNumber(2)).isEqualTo(true);
        assertThat(player.addNumber(3)).isEqualTo(true);
        assertThat(player.addNumber(4)).isEqualTo(false);
        assertThat(player.addNumber(5)).isEqualTo(false);
    }
    @Test
    void oversizeInputListTest(){
        BaseballGameNumber player1 = new BaseballGameNumber();
        BaseballGameNumber player2 = new BaseballGameNumber(Arrays.asList(1,2,3,4,5,6));
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,5,4));

        player1.setNumberList(list);

        assertThat(player1.getNumberList().size()).isEqualTo(0);
        assertThat(player2.getNumberList().size()).isEqualTo(0);
    }

}
