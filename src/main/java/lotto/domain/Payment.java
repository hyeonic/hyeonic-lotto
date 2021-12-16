package lotto.domain;

public class Payment {
    private static final int DEFAULT_PAYMENT = 0;

    private static final String VALID_NUMBER_FORMAT = "[ERROR] 금액은 숫자여아 합니다.";
    private static final String VALID_NEGATIVE_NUMBER = "[ERROR] 금액은 0원 이상이어야 합니다.";
    private static final String VALID_COMPARE_PRICE = "[ERROR] 구입 금액이 부족합니다.";

    private final int payment;

    public Payment(String inputPayment, int lottoPrice) {
        validateNumberFormat(inputPayment);
        int payment = Integer.parseInt(inputPayment);

        validateNegativeNumber(payment);
        validateMoreThanPrice(payment, lottoPrice);
        this.payment = payment;
    }

    private void validateNumberFormat(String inputPayment) {
        try {
            Integer.parseInt(inputPayment);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(VALID_NUMBER_FORMAT);
        }
    }

    private void validateNegativeNumber(int payment) {
        if (payment < DEFAULT_PAYMENT) {
            throw new IllegalArgumentException(VALID_NEGATIVE_NUMBER);
        }
    }

    private void validateMoreThanPrice(int payment, int lottoPrice) {
        if (payment < lottoPrice) {
            throw new IllegalArgumentException(VALID_COMPARE_PRICE);
        }
    }

    public int getPayment() {
        return payment;
    }
}