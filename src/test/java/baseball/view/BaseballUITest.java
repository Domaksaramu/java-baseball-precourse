package baseball.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballUITest {
    public void setUserInput(String input){
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);
    }

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
}