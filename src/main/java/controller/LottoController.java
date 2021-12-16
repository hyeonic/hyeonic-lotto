package controller;

import lotto.view.InputView;
import lotto.view.LottoCount;

public class LottoController {

    public void run() {
        LottoCount lottoCount = new LottoCount(InputView.lottoCount());
    }
}