package baseball.controller;

import baseball.domain.number.RandomNumbersGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BaseballGameServiceTest {
    private BaseballGameService baseballGameService = new BaseballGameService();
    private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final static PrintStream originalOut = System.out;

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void startBaseGameTest(){
        RandomNumbersGenerator randomNumbersGenerator = mock(RandomNumbersGenerator.class);
        when(randomNumbersGenerator.getRandomList()).thenReturn(Arrays.asList(1,2,3));
        String inputStr = "124\n" +
                "123";
        InputStream inputStream = new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);

        baseballGameService.startBaseGame(scanner, randomNumbersGenerator.getRandomList());
        String result = outContent.toString();
        assertThat(result).isEqualTo(
                "숫자를 입력해주세요 : \r\n" +
                        "2스트라이크\r\n" +
                        "숫자를 입력해주세요 : \r\n" +
                        "3스트라이크\r\n" +
                        "3개의 숫자를 모두 맞히셨습니다! 게임 종료\r\n");
    }
    @Test
    public void checkRestartGameIfWantToRestart(){
        RandomNumbersGenerator randomNumbersGenerator = mock(RandomNumbersGenerator.class);
        when(randomNumbersGenerator.getRandomList()).thenReturn(Arrays.asList(1,2,3));
        String inputStr = "1";
        InputStream inputStream = new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);
        baseballGameService.initGame(randomNumbersGenerator.getRandomList());
        Boolean restartFlatg = baseballGameService.checkRestartGame(scanner);
        String result = outContent.toString();
        assertThat(result).isEqualTo(
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\r\n");
        assertThat(restartFlatg).isEqualTo(true);

    }

    @Test
    public void checkRestartGameWantToExit(){
        RandomNumbersGenerator randomNumbersGenerator = mock(RandomNumbersGenerator.class);
        when(randomNumbersGenerator.getRandomList()).thenReturn(Arrays.asList(1,2,3));
        String inputStr = "2";
        InputStream inputStream = new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);
        baseballGameService.initGame(randomNumbersGenerator.getRandomList());
        Boolean restartFlatg = baseballGameService.checkRestartGame(scanner);
        String result = outContent.toString();
        assertThat(result).isEqualTo(
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\r\n" +
                        "게임 종료\r\n");
        assertThat(restartFlatg).isEqualTo(false);

    }
}
