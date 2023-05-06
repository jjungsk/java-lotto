package lotto.exception;

public class ManualPurchaseExceedException extends IllegalArgumentException {
    public ManualPurchaseExceedException() {
        super("총 구매수량보다 수동 발행량이 많습니다. 수동 발행량은 총 구매수량보다 많을 수 없습니다");
    }
}
