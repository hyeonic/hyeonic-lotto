package lotto.view;

public class LottoCount {
    private static final int DEFAULT_LOTTO_COUNT = 0;
    private static final int MAX_LOTTO_COUNT = 100;
    private static final int LOTTO_PRICE = 1000;

    private static final String VALID_NUMBER_FORMAT = "[ERROR] 로또 개수는 숫자여아 합니다.";
    private static final String VALID_NEGATIVE_NUMBER = "[ERROR] 로또 개수는 0개 이상이어야 합니다.";
    private static final String VALID_MAXIMUM_COUNT = "[ERROR] 로또 개수는 최대 100개 구매 가능합니다.";

    private final int lottoCount;

    public LottoCount(String inputLottoCount) {
        validateNumberFormat(inputLottoCount);
        int lottoCount = Integer.parseInt(inputLottoCount);

        validateNegativeNumber(lottoCount);
        validateMaximumCount(lottoCount);
        this.lottoCount = Integer.parseInt(inputLottoCount);
    }

    private void validateNumberFormat(String inputLottoCount) {
        try {
            Integer.parseInt(inputLottoCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALID_NUMBER_FORMAT);
        }
    }

    private void validateNegativeNumber(int lottoCount) {
        if (lottoCount < DEFAULT_LOTTO_COUNT) {
            throw new IllegalArgumentException(VALID_NEGATIVE_NUMBER);
        }
    }

    private void validateMaximumCount(int lottoCount) {
        if (lottoCount > MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException(VALID_MAXIMUM_COUNT);
        }
    }

    public int calculate() {
        return lottoCount * LOTTO_PRICE;
    }
}