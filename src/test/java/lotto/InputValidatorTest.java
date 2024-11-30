package lotto;

import lotto.validator.InputValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}