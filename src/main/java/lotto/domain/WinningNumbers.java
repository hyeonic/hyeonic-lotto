package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinningNumbers {
    private final List<LottoNumber> winningNumbers;

    public WinningNumbers(List<LottoNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<LottoNumber> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }
}