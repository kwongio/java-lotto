package lotto.service;


import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.LottoRule;

import java.util.List;

public class SortedNumberGenerator {

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LottoRule.BEGIN.getValue(), LottoRule.END.getValue(), LottoRule.SIZE.getValue()).stream()
                .sorted()
                .toList();
    }
}
