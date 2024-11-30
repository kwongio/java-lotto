package lotto.controller;

import lotto.view.InputView;
import lotto.service.LottoService;
import lotto.view.OutputView;
import lotto.service.SortedNumberGenerator;

public class LottoControllerFactory {

    private LottoControllerFactory() {
    }

    public static LottoController create() {
        return new LottoController(lottoService(), inputView(), outputView());
    }

    private static LottoService lottoService() {
        return new LottoService(sortedNumberGenerator());
    }

    private static SortedNumberGenerator sortedNumberGenerator() {
        return new SortedNumberGenerator();
    }

    private static InputView inputView() {
        return new InputView();
    }

    private static OutputView outputView() {
        return new OutputView();
    }
}
