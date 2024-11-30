package lotto.validator;

import lotto.config.ErrorMessage;
import lotto.model.Lotto;
import lotto.model.LottoRule;

import java.util.List;

public class LottoValidator {

    public static void validate(Lotto lotto) {
        if (isLottoSize(lotto.getNumbers())) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_ERROR.toString());
        }

        if (isDuplicate(lotto.getNumbers())) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATE_ERROR.toString());
        }

        if (isRange(lotto.getNumbers())) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE_ERROR.toString());
        }
    }

    private static boolean isLottoSize(List<Integer> numbers) {
        return LottoRule.isSize(numbers);
    }

    private static boolean isDuplicate(List<Integer> numbers) {
        return LottoRule.isDuplicate(numbers);
    }

    private static boolean isRange(List<Integer> numbers) {
        return LottoRule.isRange(numbers);
    }
}
