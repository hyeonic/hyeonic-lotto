package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int calculateMatchCount(LottoTicket winningNumbers) {
        long count = winningNumbers.lottoNumbers.stream()
            .filter(lottoNumbers::contains)
            .count();

        return Long.valueOf(count).intValue();
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}