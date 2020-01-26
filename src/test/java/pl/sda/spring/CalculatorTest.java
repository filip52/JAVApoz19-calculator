package pl.sda.spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.spring.exception.DivisionByZeroException;
import pl.sda.spring.operation.OperationType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class CalculatorTest {

    @Autowired
    private Calculator calculator;


    @Test
    public void shouldReturnFiveForGivenArgumentsOnAdditionOperation() {
        //given
        double arg1 = 2.0;
        double arg2 = 3.0;

        //when
        double actual = calculator.calculate(OperationType.ADDITION, arg1, arg2);

        //then
        Assert.assertEquals(5.0, actual, 0.00000001);
    }

    @Test
    public void shouldReturnArgumentsOnSubstractionOperation() {
        //given
        double arg1 = 4.0;
        double arg2 = 1.0;
        //when
        double actual = calculator.calculate(OperationType.SUBTRACTION, arg1, arg2);
        //then
        Assert.assertEquals(3.0, actual, 0.001);
    }

    @Test
    public void shouldReturnArgumentsOnMultiplyOperation() {
        //given
        double arg1 = 2.0;
        double arg2 = 3.0;
        //when
        double actual = calculator.calculate(OperationType.MULTIPLICATION, arg1, arg2);
        //then
        Assert.assertEquals(6, actual, 0.000001);
    }

    @Test
    public void shouldReturnArgumentsOnDivisionOperation() {
        //given
        double arg1 = 10.0;
        double arg2 = 5.0;
        //when
        double actual = calculator.calculate(OperationType.DIVISION, arg1, arg2);

        //then
        Assert.assertEquals(2, actual, 0.000000001);
    }

    @Test
    public void shouldReturnDontDivisionToZero() {
        //given
        double arg1 = 10.0;
        double arg2 = 0;
        //when
        double actual = calculator.calculate(OperationType.DIVISION, arg1, arg2);

        //then
        Assert.assertEquals(0, actual, 0.000001);
    }

    @Test(expected = DivisionByZeroException.class)
    public void shouldReturnException(){
        //given
        double arg1 = 10.0;
        double arg2 = 0;
        //when
        double actual = calculator.calculate(OperationType.DIVISION, arg1, arg2);

        //then
        Assert.assertEquals(0, actual, 0.000001);
//        Assert.assertEquals(actual,0.00001);
    }

    @Test
    public void shouldReturnPercentageFromNumber(){
        //given
        double arg1 = 200.00;
        double arg2 = 10.00;
        //when
        double actual = calculator.calculate(OperationType.PERCENTAGE,arg1,arg2);
        //then
        Assert.assertEquals(20,actual,0.00001);
    }
    @Test
    public void shouldReturnArgumentsOnPowerOperation() {
        //given
        double arg1 = 2.0;
        double arg2 = 2.0;
        //when
        double actual = calculator.calculate(OperationType.POWER, arg1, arg2);
        //then
        Assert.assertEquals(4, actual, 0.000001);
    }
}
