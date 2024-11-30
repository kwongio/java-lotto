package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.ErrorMessage;
import lotto.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static final String WIN_NUMBER_DELIMITER = ",";
    public static final String PURCHASE_INPUT_MESSAGE = "구입금액을 입력해주세요";
    public static final String WIN_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요";
    public static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final InputValidator inputValidator = new InputValidator();

    public int getPurchaseMoney() {
        try {
            System.out.println(PURCHASE_INPUT_MESSAGE);
            int money = Integer.parseInt(Console.readLine());
            inputValidator.validatePurchase(money);
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_MONEY_INPUT_ERROR.toString(), e);
        }
    }

    public List<Integer> getWinNumber() {
        try {
            System.out.println(WIN_NUMBER_INPUT_MESSAGE);
            List<Integer> winNumber = getWinNumber(Console.readLine());
            inputValidator.validateWinNumber(winNumber);
            return winNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_WIN_NUMBER_INPUT_ERROR.toString(), e);
        }
    }

    private List<Integer> getWinNumber(String input) {
        String[] numbers = input.split(WIN_NUMBER_DELIMITER);
        List<Integer> winNumber = new ArrayList<>();
        for (String number : numbers) {
            winNumber.add(Integer.parseInt(number));
        }
        return winNumber;
    }

    public int getBonusNumber(List<Integer> winNumber) {
        try {
            System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
            int bonusNumber = Integer.parseInt(Console.readLine());
            inputValidator.validateBonusNumber(winNumber, bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_BONUS_NUMBER_INPUT_ERROR.toString(), e);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
