package controller;

import lotto.view.InputView;
import lotto.view.LottoCount;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        getLottoCount();
    }

    private void getLottoCount() {
        try {
            LottoCount lottoCount = new LottoCount(InputView.lottoCount());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            getLottoCount();
        }
    }
}