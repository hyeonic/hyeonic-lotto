package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 5_000_000),
    SECOND(5, 500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    FIFTH(2, 0),
    SIXTH(1, 0),
    NONE(0, 0);

    private static final Rank[] VALUES = values();

    private final int matchCount;
    private final int reward;

    Rank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Rank parseRank(int matchCount) {
        return Arrays.stream(VALUES)
            .filter(rank -> rank.matchCount == matchCount)
            .findFirst()
            .orElse(NONE);
    }

    public int getReward() {
        return reward;
    }
}