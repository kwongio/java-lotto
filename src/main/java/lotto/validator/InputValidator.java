package lotto.validator;

import lotto.config.ErrorMessage;
import lotto.model.LottoRule;

import java.util.List;

public class InputValidator {

    public void validatePurchase(int money) {
        if (LottoRule.isNotDivisible(money)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_PURCHASE_MONEY_ERROR.toString());
        }
    }

    public void validateWinNumber(List<Integer> winNumber) {
        if (isWinNumberSize(winNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_WIN_NUMBER_SIZE_ERROR.toString());
        }

        if (isDuplicate(winNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATE_ERROR.toString());
        }

        if (isRange(winNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE_ERROR.toString());
        }
    }

    private static boolean isWinNumberSize(List<Integer> winNumber) {
        return LottoRule.isSize(winNumber);
    }

    private static boolean isDuplicate(List<Integer> winNumber) {
        return LottoRule.isDuplicate(winNumber);
    }

    private static boolean isRange(List<Integer> winNumber) {
        return LottoRule.isRange(winNumber);
    }

    public void validateBonusNumber(List<Integer> winNumber, int bonusNumber) {
        if (isContainWinNumber(winNumber, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_BONUS_NUMBER_DUPLICATE_ERROR.toString());
        }

        if (LottoRule.isNotRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_BONUS_NUMBER_RANGE_ERROR.toString());
        }
    }

    private static boolean isContainWinNumber(List<Integer> winNumber, int bonusNumber) {
        return winNumber.contains(bonusNumber);
    }
}
