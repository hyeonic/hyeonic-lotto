package lotto.view;

import java.util.List;

import lotto.domain.Rank;

public class OutputView {
    private static final String WINNING_NUMBERS_MESSAGE_PREFIX = "금주의 당첨 번호는 ";
    private static final String DELIMITER = ", ";
    private static final String WINNING_NUMBERS_MESSAGE_SUFFIX = "입니다.";
    private static final String LOTTO_RESULT_MESSAGE = "당신의 수익률은 아래와 같습니다.";
    private static final String LOTTO_COUNT_FORMAT = "구매 개수: %d\n";
    private static final String PAYMENT_FORMAT = "구매 금액: %d\n";
    private static final String MAX_RANK_FORMAT = "최대 당첨 등수: %s\n";
    private static final String TOTAL_REWARD_FORMAT = "총 당첨 금액: %d\n";
    private static final String YIELD_FORMAT = "수익율: %.2f%%";

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
        System.out.println();
    }

    public static void printLottoResult(int lottoCount, int payment, Rank maxRank, int totalReward, double yield) {
        System.out.println(LOTTO_RESULT_MESSAGE);
        System.out.printf(LOTTO_COUNT_FORMAT, lottoCount);
        System.out.printf(PAYMENT_FORMAT, payment);
        System.out.printf(MAX_RANK_FORMAT, maxRank.getName());
        System.out.printf(TOTAL_REWARD_FORMAT, totalReward);
        System.out.printf(YIELD_FORMAT, yield);
    }
}