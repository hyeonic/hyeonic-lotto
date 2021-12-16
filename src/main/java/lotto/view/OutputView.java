package lotto.view;

import java.util.List;

public class OutputView {
    private static final String WINNING_NUMBERS_MESSAGE_PREFIX = "금주의 당첨 번호는 ";
    private static final String DELIMITER = ", ";
    private static final String WINNING_NUMBERS_MESSAGE_SUFFIX = "입니다.";

    private OutputView() {
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
        System.out.println();
    }

    public static void printWinningNumbers(List<String> winningNumbers) {
        StringBuilder stringBuilder = new StringBuilder(WINNING_NUMBERS_MESSAGE_PREFIX);
        stringBuilder.append(String.join(DELIMITER, winningNumbers));
        stringBuilder.append(WINNING_NUMBERS_MESSAGE_SUFFIX);

        System.out.println(stringBuilder);
    }
}