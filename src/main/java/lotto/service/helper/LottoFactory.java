package lotto.service.helper;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LottoFactory {
    public static final int PRICE_OF_ONE_LOTTO = 1_000;
    private static final List<Integer> NUMBERS;

    static {
        NUMBERS = new ArrayList<>();
        for (int i = LottoNumber.VALID_MIN_NUMBER; i <= LottoNumber.VALID_MAX_NUMBER; i++) {
            NUMBERS.add(i);
        }
    }

    private LottoFactory() {
    }

    public static List<Lotto> buyLottos(List<Set<Integer>> manualLottoNumbers, int amount) {
        List<Lotto> lottos = new ArrayList<>();

        for (Set<Integer> manualLottoNumber : manualLottoNumbers) {
            lottos.add(Lotto.of(manualLottoNumber));
            amount -= PRICE_OF_ONE_LOTTO;
        }

        for (; amount >= PRICE_OF_ONE_LOTTO; amount -= PRICE_OF_ONE_LOTTO) {
            Collections.shuffle(NUMBERS);
            lottos.add(Lotto.of(NUMBERS.subList(0, Lotto.VALID_NUMBERS_SIZE)));
        }

        return lottos;
    }
}
