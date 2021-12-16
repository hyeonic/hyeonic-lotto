package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int DEFAULT_INDEX = 0;
    private static final int DEFAULT_MATCH_COUNT = 0;

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
        List<Rank> ranks = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            List<LottoNumber> lottoNumbers = lottoTicket.getLottoNumbers();
            int matchCount = getMatchCount(winningNumbers, lottoNumbers);
            ranks.add(Rank.parseRank(matchCount));
        }

        return ranks;
    }

    private int getMatchCount(WinningNumbers winningNumbers, List<LottoNumber> lottoNumbers) {
        int matchCount = DEFAULT_MATCH_COUNT;
        for (LottoNumber lottoNumber : lottoNumbers) {
            if (winningNumbers.isRight(lottoNumber)) {
                matchCount++;
            }
        }

        return matchCount;
    }
}