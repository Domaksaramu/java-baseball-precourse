package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.number.BaseballGameNumber;
import baseball.domain.number.RandomNumbersGenerator;
import baseball.view.BaseballUI;

import java.util.List;
import java.util.Scanner;

public class BaseballGameService {
    private BaseballGameNumber player;
    private BaseballGameNumber computer;
    private BaseballGame baseballGame;
    private BaseballUI baseballUI ;


    public BaseballGameService(){
    }
    public void initGame(List<Integer> randomList){
        this.player = new BaseballGameNumber();
        this.baseballGame = new BaseballGame();
        this.computer = new BaseballGameNumber(randomList);
        this.baseballUI = new BaseballUI();
    }
    public void startBaseGame(Scanner scanner, List<Integer> randomList) {
        initGame(randomList);
        String buffer = null;
        List<Integer> userInputNumbers;
        Boolean gameCompleteFlag = false;
        while (!gameCompleteFlag) {
            baseballUI.printOut("숫자를 입력해주세요 : ");
            buffer = baseballUI.getUserInput(scanner);

            baseballUI.checkInputEnable(buffer);

            userInputNumbers = baseballUI.parseUserInputIntoNumbers(buffer);
            player.setNumberList(userInputNumbers);

            baseballGame.calculateAll(computer, player);
            baseballUI.printOut(baseballGame.toString());
            gameCompleteFlag = baseballGame.getExitFlag();
        }
        baseballUI.printOut("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public Boolean checkRestartGame(Scanner scanner){
        String buffer = null;
        baseballUI.printOut("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        buffer = baseballUI.getUserInput(scanner);
        baseballUI.checkInputEnable(buffer);

        return baseballUI.parseUserInputIntoContineFlag(buffer);
    }
}
