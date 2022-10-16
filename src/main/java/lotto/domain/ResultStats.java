package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultStats {

    private final List<Lotto> lottoTickets;
    private final WinningNumber winningNumber;

    public ResultStats(final List<Lotto> lottoTickets, final WinningNumber winningNumber) {
        this.lottoTickets = lottoTickets;
        this.winningNumber = winningNumber;
    }

    public List<Integer> countPerPrize() {
        return Arrays.stream(LottoPrize.values())
                .map(prize -> (int) prizesOfUser().stream()
                        .filter(prizeOfUser -> prizeOfUser.matchCount() == prize.matchCount())
                        .filter(prizeOfUser -> prizeOfUser.matchBonus() == prize.matchBonus())
                        .count()
                ).collect(Collectors.toList());
    }

    public double returnOnInvestment(final int price) {
        return prizesOfUser().stream().mapToDouble(LottoPrize::amount).sum() / (double) price;
    }

    private List<LottoPrize> prizesOfUser() {
        return lottoTickets.stream()
                .map(ticket -> LottoPrize.of(ticket.compareNumber(winningNumber.winningNumber()), containBonusNumber(ticket)))
                .collect(Collectors.toList());
    }

    private boolean containBonusNumber(final Lotto lotto) {
        return lotto.lottoNumbers().contains(winningNumber.bonusNumber());
    }
}