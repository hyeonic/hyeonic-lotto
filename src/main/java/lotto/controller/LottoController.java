package lotto.controller;

import static java.util.stream.Collectors.*;

import java.util.List;

import lotto.domain.LottoCount;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Payment;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        LottoCount lottoCount = getLottoCount();
        Payment payment = getPayment(lottoCount);

        LottoMachine lottoMachine = new LottoMachine(new LottoNumberGenerator());
        List<LottoTicket> lottoTickets = lottoMachine.autoGenerate(lottoCount);
        WinningNumbers winningNumbers = lottoMachine.generateWinningNumber();

        printWinningNumbers(winningNumbers);

        List<Rank> ranks = lottoMachine.calculate(winningNumbers, lottoTickets);
        printResult(lottoCount, payment, ranks);
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

    private void printWinningNumbers(WinningNumbers winningNumbers) {
        List<String> numbers = winningNumbers.getWinningNumbers().stream()
            .map(LottoNumber::toString)
            .collect(toList());

        OutputView.printWinningNumbers(numbers);
    }

    private void printResult(LottoCount lottoCount, Payment payment, List<Rank> ranks) {
        LottoResult lottoResult = new LottoResult(payment, ranks);

        OutputView.printLottoResult(lottoCount.getLottoCount(), payment.getPayment(), lottoResult.maxRank(),
            lottoResult.totalReward(), lottoResult.yield());
    }
}