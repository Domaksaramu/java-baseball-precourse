package baseball.domain.number;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumbersGeneratorTest {
    @Test
    public void randomNumberListGenerateTest(){
        RandomNumbersGenerator random = new RandomNumbersGenerator();
        List<Integer> randomList = random.getRandomList();
        randomList.forEach(item ->{
                    assertThat(item)
                            .isGreaterThanOrEqualTo(1)
                            .isLessThanOrEqualTo(9);
                }
        );

        randomList = random.getRandomList();
        randomList.forEach(item ->{
                    assertThat(item)
                            .isGreaterThanOrEqualTo(1)
                            .isLessThanOrEqualTo(9);
                }
        );
        randomList = random.getRandomList();
        randomList.forEach(item ->{
                    assertThat(item)
                            .isGreaterThanOrEqualTo(1)
                            .isLessThanOrEqualTo(9);
                }
        );
    }
}
