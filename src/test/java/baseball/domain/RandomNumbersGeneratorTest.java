package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class RandomNumbersGeneratorTest {
    @Test
    public void randomNumberListGenerateTest(){
        RandomNumbersGenerator random = new RandomNumbersGenerator();
        List<Integer> randomList = random.getRandomList();

        System.out.println(randomList);
        randomList.forEach(item ->{
                    assertThat(item)
                            .isGreaterThanOrEqualTo(1)
                            .isLessThanOrEqualTo(9);
                }
        );

        random.resetRandomList();
        randomList = random.getRandomList();
        System.out.println(randomList);
        randomList.forEach(item ->{
                    assertThat(item)
                            .isGreaterThanOrEqualTo(1)
                            .isLessThanOrEqualTo(9);
                }
        );
        random.resetRandomList();
        randomList = random.getRandomList();
        System.out.println(randomList);
        randomList.forEach(item ->{
                    assertThat(item)
                            .isGreaterThanOrEqualTo(1)
                            .isLessThanOrEqualTo(9);
                }
        );
    }
}
