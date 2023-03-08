package demo.mall.exception;

public class OutOfStockException extends RuntimeException {

    // 상품의 주문 수량 > 재고 상태에서 발생하는 예외
    public OutOfStockException(String message) {
        super(message);
    }
}
