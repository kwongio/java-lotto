package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoRule;

import java.util.List;
import java.util.stream.IntStream;

public class LottoService {
    private final SortedNumberGenerator sortedNumberGenerator;

    public LottoService(SortedNumberGenerator sortedNumberGenerator) {
        this.sortedNumberGenerator = sortedNumberGenerator;
    }

    public List<Lotto> purchase(int money) {
        int quantity = LottoRule.getPurchaseQuantity(money);
        return IntStream.rangeClosed(1, quantity)
                .mapToObj(value -> new Lotto(sortedNumberGenerator.generate()))
                .toList();
    }

    public void result(List<Lotto> lottos, List<Integer> winNumber, int bonusNumber) {
        

    }
}
