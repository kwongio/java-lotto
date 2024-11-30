package lotto.validator;

import lotto.config.ErrorMessage;
import lotto.model.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoValidatorTest {

    @DisplayName("로또 사이드는 6개가 아니면 에러가 발생한다.")
    @ParameterizedTest
    @MethodSource(value = "size")
    void size(List<Integer> numbers) {
        IllegalArgumentException size = Assertions.assertThrows(IllegalArgumentException.class, () -> LottoValidator.validate(new Lotto(numbers)));
        assertThat(size.getMessage()).isEqualTo(ErrorMessage.LOTTO_SIZE_ERROR.toString());
    }

    public static Stream<Arguments> size() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 45, 55)),
                Arguments.arguments(List.of(1, 2, 3, 4, 5)),
                Arguments.arguments(List.of(1))
        );
    }
    @DisplayName("로또 번호는 중복이 있으면 에러가 발생한다.")
    @ParameterizedTest
    @MethodSource(value = "duplicate")
    void duplicate(List<Integer> numbers) {
        IllegalArgumentException duplicate = Assertions.assertThrows(IllegalArgumentException.class, () -> LottoValidator.validate(new Lotto(numbers)));
        assertThat(duplicate.getMessage()).isEqualTo(ErrorMessage.LOTTO_DUPLICATE_ERROR.toString());
    }

    public static Stream<Arguments> duplicate() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 5)),
                Arguments.arguments(List.of(1, 45, 45, 4, 5, 6)),
                Arguments.arguments(List.of(1, 1, 3, 4, 44, 45))
        );
    }

    @DisplayName("로또 번호는 1에서 45사이의 범위가 아니면 에러가 발생한다.")
    @ParameterizedTest
    @MethodSource(value = "range")
    void range(List<Integer> numbers) {
        IllegalArgumentException range = Assertions.assertThrows(IllegalArgumentException.class, () -> LottoValidator.validate(new Lotto(numbers)));
        assertThat(range.getMessage()).isEqualTo(ErrorMessage.LOTTO_RANGE_ERROR.toString());
    }

    public static Stream<Arguments> range() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 46)),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 55)),
                Arguments.arguments(List.of(1, 2, 3, 4, 55, 45))
        );
    }
}