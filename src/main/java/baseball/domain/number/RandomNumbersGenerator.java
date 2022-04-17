package baseball.domain.number;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumbersGenerator {
    private List<Integer> randomList;
    private Long randomSeed;

    public static final Integer MIN_NUMBER_RANGE = 1;
    public static final Integer MAX_NUMBER_RANGE= 9;

    public RandomNumbersGenerator(){}

    public void resetRandomList() {
        randomSeed = System.currentTimeMillis();
        this.randomList = new Random(randomSeed)
                .ints(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE + 1)
                .distinct()
                .limit(BaseballGameNumber.MAX_BASEBALL_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getRandomList() {
        return randomList;
    }
}
