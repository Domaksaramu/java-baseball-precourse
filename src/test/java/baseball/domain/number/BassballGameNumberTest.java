package baseball.domain.number;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BassballGameNumberTest {
    @Test
    void duplicatedNumberTest(){
        List<Integer> basePlayerInput = new ArrayList<>(Arrays.asList(1,2));
        BaseballGameNumber player = new BaseballGameNumber(basePlayerInput);
        assertThat(player.checkDuplicateNumber(1)).isEqualTo(true);
        assertThat(player.checkDuplicateNumber(2)).isEqualTo(true);
        assertThatThrownBy(() -> player.checkDuplicateNumber(3))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void duplicatedNumberInputTest(){
        List<Integer> basePlayerInput = new ArrayList<>(Arrays.asList(1,2));
        BaseballGameNumber player = new BaseballGameNumber(basePlayerInput);
        assertThatThrownBy(() -> player.addNumber(1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> player.addNumber(2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(player.addNumber(3)).isEqualTo(true);
        assertThatThrownBy(() -> player.addNumber(3))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void oversizeInputTest(){
        BaseballGameNumber player = new BaseballGameNumber();
        assertThat(player.addNumber(1)).isEqualTo(true);
        assertThat(player.addNumber(2)).isEqualTo(true);
        assertThat(player.addNumber(3)).isEqualTo(true);
        assertThatThrownBy(() -> player.addNumber(4))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> player.addNumber(5))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void oversizeInputListTest(){
        BaseballGameNumber player1 = new BaseballGameNumber();
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,5,4));


        assertThatThrownBy(() -> new BaseballGameNumber(Arrays.asList(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> player1.setNumberList(list))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
