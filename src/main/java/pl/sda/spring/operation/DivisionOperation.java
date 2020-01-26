package pl.sda.spring.operation;

import org.springframework.stereotype.Component;
import pl.sda.spring.exception.DivisionByZeroException;

@Component
public class DivisionOperation implements Operation {

    private final String exceptionMessage;
    public DivisionOperation(String exceptionMessage){
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public double calculate(double arg1, double arg2) {
        DivisionByZeroException ex;
        if (arg2 == 0) {
            throw new DivisionByZeroException(exceptionMessage);
        }
            return arg1 / arg2;
    }

    @Override
    public OperationType getSupportedOperationType() {
        return OperationType.DIVISION;
    }


}




