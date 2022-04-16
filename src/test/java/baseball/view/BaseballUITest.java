package baseball.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballUITest {
    @Test
    public void getUserInputTest(){
        BaseballUI baseballUI = new BaseballUI();
        String inputStr = "123";
        InputStream inputStream = new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);

        assertThat(baseballUI.getUserInput(scanner)).isEqualTo("123");

        inputStr="1234";
        inputStream = new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);
        scanner = new Scanner(System.in);
        assertThat(baseballUI.getUserInput(scanner)).isEqualTo("1234");


        inputStr="tttt";
        inputStream = new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);
        Scanner scanner2 = new Scanner(System.in);
        assertThatThrownBy(() -> baseballUI.getUserInput(scanner2))
                .isInstanceOf(InputMismatchException.class);
    }
    @Test
    public void checkInputEnableTest(){
        BaseballUI baseballUI = new BaseballUI();
        String inputStr = "123";
        InputStream inputStream = new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);

        assertThat(
                baseballUI.checkInputEnable(baseballUI.getUserInput(scanner))
        ).isEqualTo(true);

        inputStr="1234";
        inputStream = new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);
        scanner = new Scanner(System.in);
        assertThat(
                baseballUI.checkInputEnable(baseballUI.getUserInput(scanner))
        ).isEqualTo(false);

        inputStr="1";
        inputStream = new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);
        scanner = new Scanner(System.in);
        assertThat(
                baseballUI.checkInputEnable(baseballUI.getUserInput(scanner))
        ).isEqualTo(true);
    }
    @Test
    public void parseUserInputIntoNumbersTest(){
        BaseballUI baseballUI = new BaseballUI();
        String inputStr = "123";
        InputStream inputStream = new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);
        Scanner scanner = new Scanner(System.in);

        assertThat(
                baseballUI.parseUserInputIntoNumbers(baseballUI.getUserInput(scanner))
        ).containsExactly(1,2,3);


        inputStr = "948";
        inputStream = new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);
        scanner = new Scanner(System.in);

        assertThat(
                baseballUI.parseUserInputIntoNumbers(baseballUI.getUserInput(scanner))
        ).containsExactly(9,4,8);
    }
}
