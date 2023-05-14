package lotto.step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Fixture {
    static class TestLotto extends Lotto {
        public TestLotto(Set<Integer> lotto) {
            super(lotto);
        }

        public static Lotto of(Integer... numbers) {
            return new Lotto(Arrays.stream(numbers).collect(Collectors.toSet()));
        }
    }
}