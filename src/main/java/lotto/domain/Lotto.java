package lotto.domain;

import lotto.util.LottoGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_COMPOSITION_NUMBER = 6;

    private List<LottoNumber> lottoNumbers;

    public Lotto(LottoGenerator generator) {
        this.lottoNumbers = new ArrayList<>();
        initLotto(generator);
    }

    private void initLotto(LottoGenerator generator) {
        while (lottoNumbers.size() < LOTTO_COMPOSITION_NUMBER) {
            initSingleLottoNumber(generator);
            lottoNumbers = lottoNumbers.stream()
                    .distinct()
                    .collect(Collectors.toList());
        }
        Collections.sort(lottoNumbers);
    }

    private void initSingleLottoNumber(LottoGenerator generator) {
        LottoNumber lottoNumber = new LottoNumber(generator.generatorNumber());
        lottoNumbers.add(lottoNumber);
    }

    public int getCountByMatch(Lotto lotto) {
        return (int) lottoNumbers.stream()
                .filter(lotto.lottoNumbers::contains)
                .count();
    }


    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }
}