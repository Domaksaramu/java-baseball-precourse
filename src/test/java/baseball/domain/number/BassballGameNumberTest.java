package baseball.domain.number;


import baseball.domain.number.BaseballGameNumber;
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
}
