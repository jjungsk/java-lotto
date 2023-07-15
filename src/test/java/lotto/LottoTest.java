package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import lotto.domain.game.Lotto;
import lotto.domain.game.LottoNumber;
import lotto.domain.game.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTest {

    @DisplayName("보너스볼이 로또안에 있으면 true를 반환한다")
    @Test
    void 로또_보너스볼_중복_O() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6), false);
        LottoNumber lottoNumber = new LottoNumber(1);

        assertThat(lotto.hasLottoNumber(lottoNumber)).isTrue();
    }

    @DisplayName("보너스볼이 로또안에 있으면 false를 반환한다")
    @Test
    void 로또_보너스볼_중복_X() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6), false);
        LottoNumber lottoNumber = new LottoNumber(10);

        assertThat(lotto.hasLottoNumber(lottoNumber)).isFalse();
    }

    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다")
    @Test
    void 로또_객체_생성_실패_개수() {
        List<Integer> values = List.of(1, 2, 3, 5);
        Assertions.assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new Lotto(values, false))
            .withMessage("로또 번호는 6개여야합니다");
    }

    @DisplayName("로또 번호가 중복되면 예외가 발생한다")
    @Test
    void 로또_객체_생성_실패_중복() {
        List<Integer> values = List.of(1, 2, 3, 5, 5, 5);
        Assertions.assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new Lotto(values, false))
            .withMessage("로또 번호는 중복되지 않아야합니다");
    }

    @DisplayName("로또객체가 정상적으로 생성된다")
    @Test
    void 로또_객체_생성_성공() {
        List<Integer> values = List.of(1, 2, 3, 4, 5, 6);
        assertThatNoException()
            .isThrownBy(() -> new Lotto(values, false));
    }

    @DisplayName("일치하는 숫자를 카운트 한다")
    @Test
    void 로또_일치_카운트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6), false);
        String winingValue = "5,1,10,45,2,29";

        WinningNumber winningNumber = new WinningNumber(winingValue, 30);

        assertThat(lotto.countMatch(winningNumber.getWinningLotto()))
            .isEqualTo(3);
    }

    @DisplayName("자동 로또 생성 테스트")
    @Test
    void 로또_자동_생성() {
        Lotto lotto = new Lotto(List.of(12, 23, 45, 1, 7, 8, 9, 19), true);
        String winingValue = "12,23,45,1,7,8";

        WinningNumber winningNumber = new WinningNumber(winingValue, 30);

        assertThat(lotto.countMatch(winningNumber.getWinningLotto()))
            .isEqualTo(6);
    }

    @DisplayName("숫자가 아니면 에러가 발생한다")
    @ValueSource(strings = {"a", "가나다"})
    @ParameterizedTest()
    void 로또_번호_검증_실패_문자(String value) {
        assertThatExceptionOfType(NumberFormatException.class)
            .isThrownBy(() -> new Lotto(value, false));
    }

    @DisplayName("로또 안에 입력한 로또 번호가 있다")
    @Test
    void lottoNumbersinLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6), false);
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(2);
        LottoNumber lottoNumber3 = new LottoNumber(3);
        LottoNumber lottoNumber4 = new LottoNumber(4);
        LottoNumber lottoNumber5 = new LottoNumber(5);
        LottoNumber lottoNumber6 = new LottoNumber(6);

        assertThat(lotto.getLotto()).containsExactlyElementsOf(List.of(
            lottoNumber1,
            lottoNumber2,
            lottoNumber3,
            lottoNumber4,
            lottoNumber5,
            lottoNumber6
        ));
    }

}
