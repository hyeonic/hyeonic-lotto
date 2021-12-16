package lotto.controller;

import java.util.List;

import lotto.domain.LottoCount;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoTicket;
import lotto.domain.Payment;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoController(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public void run() {
        LottoCount lottoCount = getLottoCount();
        Payment payment = getPayment(lottoCount);

        LottoMachine lottoMachine = new LottoMachine(lottoNumberGenerator);
        List<LottoTicket> lottoTickets = lottoMachine.autoGenerate(lottoCount);
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