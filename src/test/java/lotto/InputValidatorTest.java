package lotto;

import lotto.config.ErrorMessage;
import lotto.validator.InputValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("로또 구매는 1,000원 단위로 구매하면 성공한다.")
    @Test
    void purchase() {
        InputValidator inputValidator = new InputValidator();
        Assertions.assertDoesNotThrow(() -> inputValidator.validatePurchase(1000));
    }

    @DisplayName("로또 구매는 1,000원 단위로 구매하지 않으면 실패한다.")
    @Test
    void purchaseFail() {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.validatePurchase(1001)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호는 중복되지 않는다.")
    @Test
    void winNumber() {
        InputValidator inputValidator = new InputValidator();
        inputValidator.validateWinNumber(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("당첨 번호는 중복되면 에러가 발생한다.")
    @Test
    void winNumberDuplicate() {
        InputValidator inputValidator = new InputValidator();
        IllegalArgumentException error = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> inputValidator.validateWinNumber(List.of(1, 1, 1, 4, 5, 6))
        );
        assertThat(error.getMessage()).isEqualTo(ErrorMessage.LOTTO_WIN_NUMBER_DUPLICATE_ERROR.toString());
    }

    @DisplayName("당첨 번호는 1에서 45사이의 범위가 아니면 에러가 발생한다.")
    @ParameterizedTest
    @MethodSource(value = "duplicateWinNumber")
    void winNumberRange(List<Integer> winNumber) {
        InputValidator inputValidator = new InputValidator();
        IllegalArgumentException error = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> inputValidator.validateWinNumber(winNumber)
        );
        assertThat(error.getMessage()).isEqualTo(ErrorMessage.LOTTO_WIN_NUMBER_RANGE_ERROR.toString());
    }

    public static Stream<Arguments> duplicateWinNumber() {
        return Stream.of(
                Arguments.arguments(List.of(1,2,3,4,5,46)),
                Arguments.arguments(List.of(1,2,3,4,5,55)),
                Arguments.arguments(List.of(1,2,3,4,55,45))
        );
    }
}