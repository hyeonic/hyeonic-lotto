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

    public int getMatchCount(List<LottoNumber> lottoNumbers) {
        long count = lottoNumbers.stream()
            .filter(winningNumbers::contains)
            .count();

        return Long.valueOf(count).intValue();
    }
}