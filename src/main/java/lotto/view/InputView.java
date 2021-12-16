package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_LOTTO_COUNT_MESSAGE = "구매할 로또의 개수를 입력해주세요.";
    private static final String INPUT_PRICE_MESSAGE_FORMAT = "금액은 %d원 입니다. 구입 금액을 입력해주세요.\n";

    private InputView() {
    }

    public static String lottoCount() {
        System.out.println(INPUT_LOTTO_COUNT_MESSAGE);
        return Console.readLine();
    }

    public static String payment(int price) {
        System.out.printf(INPUT_PRICE_MESSAGE_FORMAT, price);
        return Console.readLine();
    }
}