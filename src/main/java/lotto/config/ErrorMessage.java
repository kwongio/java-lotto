package lotto.config;

public enum ErrorMessage {
    LOTTO_PURCHASE_MONEY_ERROR("구매 금액은 1,000원 단위여야 합니다."),
    LOTTO_MONEY_INPUT_ERROR("구매금액은 숫자로 입력해주세요"),
    LOTTO_SIZE_ERROR("로또 번호는 6개여야 합니다."),
    LOTTO_DUPLICATE_ERROR("로또 번호는 중복되지 않는 6자리 숫자입니다."),
    LOTTO_RANGE_ERROR("로도 번호는 1에서 45사이입니다."),

    LOTTO_WIN_NUMBER_INPUT_ERROR("당첨 번호는 숫자로 입력해야합니다."),
    LOTTO_WIN_NUMBER_SIZE_ERROR("당첨 번호는 6개여야 합니다."),
    LOTTO_WIN_NUMBER_DUPLICATE_ERROR("당첨 번호는 중복되지 않는 6자리 숫자입니다."),
    LOTTO_WIN_NUMBER_RANGE_ERROR("당첨 번호는 1에서 45사이입니다."),

    LOTTO_BONUS_NUMBER_INPUT_ERROR("보너스 번호는 숫자로 입력해야합니다"),
    LOTTO_BONUS_NUMBER_DUPLICATE_ERROR("보너스 번호는 당첨 번호에 없는 번호여야 합니다."),
    LOTTO_BONUS_NUMBER_RANGE_ERROR("보너스 번호는 1에서 45사이입니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return PREFIX + message;
    }
}
