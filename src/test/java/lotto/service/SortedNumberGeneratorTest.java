package lotto.service;

import lotto.model.LottoRule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class SortedNumberGeneratorTest {

    @DisplayName("정렬된 6자리 랜덤 당첨 번호를 생성한다.")
    @Test
    void generate() {
        SortedNumberGenerator sortedNumberGenerator = new SortedNumberGenerator();
        List<Integer> winNumbers = sortedNumberGenerator.generate();
        Assertions.assertThat(winNumbers).isSorted();
        Assertions.assertThat(winNumbers).doesNotHaveDuplicates();
        Assertions.assertThat(winNumbers).hasSize(LottoRule.SIZE.getValue());
        Assertions.assertThat(LottoRule.isRange(winNumbers)).isTrue();

    }
}