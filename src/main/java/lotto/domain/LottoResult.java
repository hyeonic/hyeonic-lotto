package lotto.domain;

import java.util.List;

public class LottoResult {
    private static final int PERCENT = 100;

    private final Payment payment;
    private final List<Rank> ranks;

    public LottoResult(Payment payment, List<Rank> ranks) {
        this.payment = payment;
        this.ranks = ranks;
    }

    public double yield() {
        return (double) totalReward() / payment.getPayment() * PERCENT;
    }

    public int totalReward() {
        return ranks.stream()
            .mapToInt(Rank::getReward)
            .sum();
    }

    public Rank maxRank() {
        Rank maxRank = Rank.NONE;
        int maxReward = 0;
        for (Rank rank : ranks) {
            if (maxReward < rank.getReward()) {
                maxRank = rank;
                maxReward = rank.getReward();
            }
        }

        return maxRank;
    }
}