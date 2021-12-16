package lotto.domain;

public class Payment {
    private final int payment;

    public Payment(String inputPayment, int lottoPrice) {
        this.payment = Integer.parseInt(inputPayment);
    }
}