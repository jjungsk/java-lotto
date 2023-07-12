package view;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import lottogame.Lotto;
import lottogame.LottoMatch;
import lottogame.LottoMatchKey;
import lottogame.Lottos;

public final class LottoView {

    private final Scanner scanner = new Scanner(System.in);

    public String readPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public String readWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public String readBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusBall = scanner.nextLine();
        scanner.close();
        return bonusBall;
    }

    public void printLottoCount(final int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottos(final Lottos lottos) {
        lottos.getLottos().stream()
            .map(Lotto::getLottoNumbers)
            .forEach((number) -> System.out.println("[" + number + "]"));
    }

    public void printLottoStatistics(final Map<LottoMatch, Integer> resultMap) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Arrays.stream(LottoMatch.values())
            .map((lottoMatch -> resultMessage(lottoMatch, resultMap)))
            .forEach(System.out::println);
    }

    private String resultMessage(LottoMatch lottoMatch, final Map<LottoMatch, Integer> resultMap) {
        String bonusMessage = "";
        LottoMatchKey lottoMatchKey = lottoMatch.getLottoMatchKey();
        if (lottoMatchKey.getIsBonus()) {
            bonusMessage = ", 보너스 볼 일치";
        }
        return MessageFormat.format("{0}개 일치{1} ({2}원) - {3}개",
            lottoMatchKey.getMatchCount(), bonusMessage, lottoMatch.getPrize(), resultMap.get(lottoMatch));
    }

    public void printProfitRate(final String profitRate) {
        System.out.println("총 수익률은" + profitRate + "입니다.");
    }
}
