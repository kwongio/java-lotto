package lotto.model;

import java.util.List;

public enum LottoRule {

    PRICE(1000),
    BEGIN(1),
    END(45),
    SIZE(6);

    private final int value;

    LottoRule(int value) {
        this.value = value;
    }

    public static boolean isSize(List<Integer> numbers) {
        return numbers.size() == SIZE.value;
    }

    public static boolean isDuplicate(List<Integer> numbers) {
        return isSize(numbers.stream()
                .distinct()
                .toList());
    }

    public static boolean isNotDivisible(int money) {
        return money % PRICE.value != 0;
    }

    public static boolean isRange(int number) {
        return BEGIN.value <= number && number <= END.value;
    }

    public static boolean isNotRange(int number) {
        return !isRange(number);
    }

    public static boolean isRange(List<Integer> number) {
        return number.stream().noneMatch(LottoRule::isRange);
    }

    public static int getPurchaseQuantity(int money) {
        return money / PRICE.value;
    }

    public int getValue() {
        return value;
    }
}
