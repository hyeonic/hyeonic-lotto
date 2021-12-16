package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST("1등", 6, 5_000_000),
    SECOND("2등", 5, 500_000),
    THIRD("3등", 4, 50_000),
    FOURTH("4등", 3, 5_000),
    FIFTH("5등", 2, 0),
    SIXTH("6등", 1, 0),
    NONE("7등", 0, 0);

    private static final Rank[] VALUES = values();

    private final String name;
    private final int matchCount;
    private final int reward;

    Rank(final String name, final int matchCount, final int reward) {
        this.name = name;
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Rank parseRank(int matchCount) {
        return Arrays.stream(VALUES)
            .filter(rank -> rank.matchCount == matchCount)
            .findFirst()
            .orElse(NONE);
    }

    public String getName() {
        return name;
    }

    public int getReward() {
        return reward;
    }
}