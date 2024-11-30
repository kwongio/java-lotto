package lotto.controller;

import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.service.LottoService;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int money = inputView.getPurchaseMoney();
        List<Lotto> lottos = lottoService.purchase(money);
        List<Integer> winNumber = inputView.getWinNumber();
        int bonusNumber = inputView.getBonusNumber(winNumber);
        lottoService.result(lottos, winNumber, bonusNumber);
    }
}
