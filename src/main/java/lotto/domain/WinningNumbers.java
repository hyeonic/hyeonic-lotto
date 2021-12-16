package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinningNumbers {
    private static final int DEFAULT_MATCH_COUNT = 0;

    private final List<LottoNumber> winningNumbers;

    public WinningNumbers(List<LottoNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<LottoNumber> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    public int getMatchCount(List<LottoNumber> lottoNumbers) {
        int matchCount = DEFAULT_MATCH_COUNT;
        for (LottoNumber lottoNumber : lottoNumbers) {
            if (isRight(lottoNumber)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    private boolean isRight(LottoNumber lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }
}