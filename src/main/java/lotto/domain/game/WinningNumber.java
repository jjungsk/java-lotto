package lotto.domain.game;

public final class WinningNumber {

    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    public WinningNumber(final String lottoValue, final int bonusValue) {
        Lotto lotto = new Lotto(lottoValue, false);
        LottoNumber lottoNumber = new LottoNumber(bonusValue);

        validate(lotto, lottoNumber);

        winningLotto = lotto;
        bonusBall = lottoNumber;
    }

    private void validate(final Lotto lotto, final LottoNumber lottoNumber) {
        if (lotto.hasLottoNumber(lottoNumber)) {
            throw new IllegalArgumentException("보너스볼이 당첨번호에 존재합니다");
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }
}