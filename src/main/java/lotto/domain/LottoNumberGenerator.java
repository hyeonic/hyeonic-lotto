package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumberGenerator {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public List<LottoNumber> generate() {
        List<Integer> lottoNumbers = new ArrayList<>();
        List<Integer> numbers = getNumbers();

        while (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInList(numbers);
            if (!lottoNumbers.contains(randomNumber)) {
                lottoNumbers.add(randomNumber);
            }
        }

        return toLottoNumberList(lottoNumbers);
    }

    private static List<Integer> getNumbers() {
        return IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .boxed()
            .collect(toList());
    }

    private List<LottoNumber> toLottoNumberList(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
            .map(LottoNumber::new)
            .collect(toList());
    }
}