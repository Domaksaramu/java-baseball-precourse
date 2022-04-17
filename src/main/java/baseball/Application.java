package baseball;

import baseball.controller.BaseballGameService;
import baseball.domain.number.RandomNumbersGenerator;

import java.util.List;
import java.util.Scanner;

public class Application {
    private static Scanner scanner = new Scanner(System.in);
    private static RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();
    private static BaseballGameService baseballGameService = new BaseballGameService();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Boolean contineFlag = true;
        while(contineFlag){
            List<Integer> randomList = randomNumbersGenerator.getRandomList();
            baseballGameService.startBaseGame(scanner,randomList);
            contineFlag = baseballGameService.checkRestartGame(scanner);
        }
    }
}
