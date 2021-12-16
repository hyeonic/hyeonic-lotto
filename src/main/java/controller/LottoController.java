package controller;

import lotto.view.InputView;
import domain.LottoCount;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        LottoCount lottoCount = getLottoCount();
    }

    private LottoCount getLottoCount() {
        try {
            return new LottoCount(InputView.lottoCount());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getLottoCount();
        }
    }
}