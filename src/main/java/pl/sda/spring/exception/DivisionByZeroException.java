package pl.sda.spring.exception;

public class DivisionByZeroException extends RuntimeException {


    public DivisionByZeroException(String message) {
        super(message);
    }
}
