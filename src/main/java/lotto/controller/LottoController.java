package lotto.controller;

import lotto.domain.LottoCount;
import lotto.domain.Payment;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        LottoCount lottoCount = getLottoCount();
        Payment payment = getPayment(lottoCount);
    }

    private LottoCount getLottoCount() {
        try {
            return new LottoCount(InputView.lottoCount());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getLottoCount();
        }
    }

    private Payment getPayment(LottoCount lottoCount) {
        try {
            return new Payment(InputView.payment(lottoCount.calculate()), lottoCount.calculate());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getPayment(lottoCount);
        }
    }
}