package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private static final int DEFAULT_INDEX = 0;

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoMachine(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<LottoTicket> autoGenerate(LottoCount lottoCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = DEFAULT_INDEX; i < lottoCount.getLottoCount(); i++) {
            List<LottoNumber> lottoNumbers = lottoNumberGenerator.generate();
            lottoTickets.add(new LottoTicket(lottoNumbers));
        }

        return lottoTickets;
    }

    public WinningNumbers generateWinningNumber() {
        return new WinningNumbers(lottoNumberGenerator.generate());
    }

    public List<Rank> calculate(WinningNumbers winningNumbers, List<LottoTicket> lottoTickets) {
        return lottoTickets.stream()
            .map(winningNumbers::getMatchCount)
            .map(Rank::parseRank)
            .collect(Collectors.toList());
    }
}