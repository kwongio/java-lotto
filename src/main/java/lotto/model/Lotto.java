package lotto.model;

import lotto.validator.LottoValidator;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        LottoValidator.validate(this);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
