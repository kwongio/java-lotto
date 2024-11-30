package lotto.validator;

import lotto.config.ErrorMessage;
import lotto.model.Lotto;
import lotto.config.LottoRule;

public class LottoValidator {

    public static void validate(Lotto lotto) {
        if (LottoRule.isNotSize(lotto.getNumbers())) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_ERROR.toString());
        }

        if (LottoRule.isDuplicate(lotto.getNumbers())) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATE_ERROR.toString());
        }

        if (LottoRule.isNotRange(lotto.getNumbers())) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE_ERROR.toString());
        }
    }
}
