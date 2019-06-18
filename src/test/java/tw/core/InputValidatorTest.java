package tw.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.validator.InputValidator;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    private InputValidator inputValidator;

    @Before
    public void setUp() {
        inputValidator = new InputValidator();
    }

    @Test
    public void should_return_true_when_answer_correct() {
        Boolean isValidated = inputValidator.validate("1 2 3 4");
        Assert.assertEquals(isValidated, true);
    }

    @Test
    public void should_return_false_when_the_length_of_number_is_not_4() {
        Boolean isValidated = inputValidator.validate("1 2 3");
        Assert.assertEquals(isValidated, false);
    }

    @Test
    public void should_return_false_when_a_number_bigger_then_10() {
        Boolean isValidated = inputValidator.validate("1 2 3 10");
        Assert.assertEquals(isValidated, false);
    }

    @Test
    public void should_return_false_when_numbers_repeat() {
        Boolean isValidated = inputValidator.validate("1 1 2 3");
        Assert.assertEquals(isValidated, false);
    }
}
