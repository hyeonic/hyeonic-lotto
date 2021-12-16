package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_LOTTO_COUNT_MESSAGE = "구매할 로또의 개수를 입력해주세요.";

    private InputView() {
    }

    public static String lottoCount() {
        System.out.println(INPUT_LOTTO_COUNT_MESSAGE);
        return Console.readLine();
    }
}