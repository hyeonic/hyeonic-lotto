package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinningNumbers {
    private final LottoTicket winningNumbers;

    public WinningNumbers(List<LottoNumber> winningNumbers) {
        this.winningNumbers = new LottoTicket(winningNumbers);
    }

    public List<LottoNumber> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers.getLottoNumbers());
    }

    public int getMatchCount(LottoTicket lottoTicket) {
        return lottoTicket.calculateMatchCount(winningNumbers);
    }
}